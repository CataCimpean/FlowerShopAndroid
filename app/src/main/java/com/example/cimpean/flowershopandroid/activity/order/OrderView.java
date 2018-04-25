package com.example.cimpean.flowershopandroid.activity.order;

import com.example.cimpean.flowershopandroid.model.Order;

import java.util.List;

/**
 * Created by Cimpean on 4/24/2018.
 */
public interface OrderView {
    void showProgress();
    void hideProgress();
    void setItems(List<Order> items);
    void showMessage(String message);
}
