package com.example.cimpean.flowershopandroid.activity.main;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cimpean.flowershopandroid.R;
import com.example.cimpean.flowershopandroid.model.Flower;

import java.util.List;

/**
 * Created by Cimpean on 4/23/2018.
 */
public class FlowerAdapter extends ArrayAdapter<Flower> {

    private Context context;
    private int layoutResourceId;
    private List<Flower> data = null;


    public FlowerAdapter(Context context, int resource, List<Flower> objects) {
        super(context, resource, objects);

        this.layoutResourceId = resource;
        this.context = context;
        this.data = objects;

    }

    static class DataHolder
    {
        ImageView ivFlag;
        TextView tvName;
        TextView tvDescription;

    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        DataHolder holder = null;

        if(convertView == null){
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            convertView = inflater.inflate(layoutResourceId,null);
            holder = new DataHolder();
            holder.ivFlag = (ImageView)convertView.findViewById(R.id.imageView);
            holder.tvName =(TextView)convertView.findViewById(R.id.textView_name);
            holder.tvDescription = (TextView)convertView.findViewById(R.id.textView_description);

            convertView.setTag(holder);
        }else{
            holder = (DataHolder)convertView.getTag();
        }

        Flower flowerItem = data.get(position);
        holder.tvName.setText(flowerItem.getName());
        holder.tvDescription.setText(flowerItem.getDescription());
        holder.ivFlag.setImageResource(flowerItem.getResIdThumbnail());

        return convertView;
    }

}