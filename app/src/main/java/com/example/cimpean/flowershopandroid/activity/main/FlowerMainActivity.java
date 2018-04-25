package com.example.cimpean.flowershopandroid.activity.main;

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
import com.example.cimpean.flowershopandroid.model.Flower;

import java.util.List;

public class FlowerMainActivity extends Activity implements MainView, AdapterView.OnItemClickListener {


    private ListView listView;
    private ProgressBar progressBar;
    private MainPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flower_main);

        listView = (ListView) findViewById(R.id.listView);
        listView.setOnItemClickListener(this);
        progressBar = (ProgressBar) findViewById(R.id.progress1);
        presenter = new MainPresenterImpl(this, new FlowerInteractorImpl());
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
    public void setItems(List<Flower> items) {
        listView.setAdapter(new FlowerAdapter(this,R.layout.flowers_fragment,items));
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        presenter.onItemClicked(position,this,this);
    }

}
