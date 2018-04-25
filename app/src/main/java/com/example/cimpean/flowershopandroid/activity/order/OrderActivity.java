package com.example.cimpean.flowershopandroid.activity.order;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.cimpean.flowershopandroid.R;
import com.example.cimpean.flowershopandroid.model.Order;
import com.example.cimpean.flowershopandroid.utils.CheckVersion;

import java.util.List;

/**
 * Created by Cimpean on 4/24/2018.
 */
public class OrderActivity extends Activity implements OrderView, AdapterView.OnItemClickListener   {

    private ListView listView;
    private ProgressBar progressBar;
    private OrderPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        CheckVersion.checkSDKVersion();

        listView = (ListView) findViewById(R.id.listViewOrders);
        listView.setOnItemClickListener(this);
        progressBar = (ProgressBar) findViewById(R.id.progress2);

        String flowerType = getIntent().getStringExtra("FlowerName");

        presenter = new OrderPresenterImpl(this, new OrderInteractorImpl(),flowerType,this);

    }
    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }


    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
        listView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.INVISIBLE);
        listView.setVisibility(View.VISIBLE);
    }

    @Override
    public void setItems(List<Order> items) {
        listView.setAdapter(new OrderAdapter(this,R.layout.orders_fragment,items));
        OrderAdapter myAdapter = (OrderAdapter)listView.getAdapter();
        myAdapter.notifyDataSetChanged();
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        presenter.onItemClicked(view,position);
    }

}
