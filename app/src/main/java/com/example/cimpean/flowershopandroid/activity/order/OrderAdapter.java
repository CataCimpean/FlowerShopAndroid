package com.example.cimpean.flowershopandroid.activity.order;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.cimpean.flowershopandroid.R;
import com.example.cimpean.flowershopandroid.model.Order;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Cimpean on 4/24/2018.
 */
public class OrderAdapter extends ArrayAdapter<Order> {


    private Context context;
    private int layoutResourceId;
    private List<Order> data = null;


    public OrderAdapter(Context context, int resource, List<Order> objects) {
        super(context, resource, objects);
        this.layoutResourceId = resource;
        this.context = context;
        this.data = objects;

    }

    static class DataHolder
    {
        TextView tvId;
        TextView tvDeliverTo;
        TextView tvFlowerType;
        TextView tvDeliveryDate;
        TextView tvAddresTo;
        TextView tvPrice;

    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        DataHolder holder = null;

        if(convertView == null){
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            convertView = inflater.inflate(layoutResourceId,null);
            holder = new DataHolder();
            holder.tvId = (TextView)convertView.findViewById(R.id.textView_orderId);
            holder.tvDeliverTo =(TextView)convertView.findViewById(R.id.textView_deliverTo);
            holder.tvFlowerType =(TextView)convertView.findViewById(R.id.textView_flowerType);
            holder.tvAddresTo = (TextView)convertView.findViewById(R.id.textView_AddressTo);
            holder.tvDeliveryDate = (TextView)convertView.findViewById(R.id.textView_orderDate);
            holder.tvPrice = (TextView)convertView.findViewById(R.id.textView_Price);

            convertView.setTag(holder);
        }else{
            holder = (DataHolder)convertView.getTag();
        }

        Order orderItem = data.get(position);

        holder.tvId.setText(String.valueOf(orderItem.getId()));
        holder.tvDeliverTo.setText(orderItem.getDeliver_to());
        holder.tvDeliveryDate.setText(getDateAsString(orderItem.getDelivery_date()));
        holder.tvAddresTo.setText(orderItem.getAddress());
        holder.tvPrice.setText(String.valueOf(orderItem.getPrice() +"$"));
        holder.tvFlowerType.setText(orderItem.getFlowerType());

        return convertView;
    }


    public String getDateAsString(Date orderDate){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateAsString = sdf.format(new Date());
        return dateAsString;
    }

}
