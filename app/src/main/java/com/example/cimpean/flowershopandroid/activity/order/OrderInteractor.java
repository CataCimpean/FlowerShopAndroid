package com.example.cimpean.flowershopandroid.activity.order;

import android.content.Context;

import com.example.cimpean.flowershopandroid.model.Order;

import java.util.List;

/**
 * Created by Cimpean on 4/24/2018.
 */
public interface OrderInteractor  {

    interface OnFinishedListener {
        void onFinished(List<Order> items);
    }

    void findItems(OnFinishedListener listener, String typeOfFlower, Context context, OrderView orderView);

}
