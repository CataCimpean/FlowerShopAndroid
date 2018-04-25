package com.example.cimpean.flowershopandroid.activity.order;

import android.content.Context;
import android.view.View;

import com.example.cimpean.flowershopandroid.model.Order;

import java.util.List;

/**
 * Created by Cimpean on 4/24/2018.
 */
public class OrderPresenterImpl implements OrderPresenter, OrderInteractorImpl.OnFinishedListener  {


    private OrderView orderView;
    private OrderInteractor findItemsInteractor;
    private String flowerType;
    private Context context;

    public OrderPresenterImpl(OrderView orderView, OrderInteractor findItemsInteractor,String flowerType,Context context) {
        this.orderView = orderView;
        this.findItemsInteractor = findItemsInteractor;
        this.flowerType = flowerType;
        this.context =  context;
    }


    @Override
    public void onResume() {

        if (orderView != null) {
            orderView.showProgress();
        }

        findItemsInteractor.findItems(this,flowerType,context,orderView);
    }

    @Override
    public void onItemClicked(View view, int position) {
        if (orderView != null) {
            orderView.showMessage(String.format("Position %d clicked", position + 1));
        }
    }

    @Override
    public void onDestroy() {

        orderView = null;
    }

    @Override
    public void onFinished(List<Order> items) {
        if (orderView != null) {
            orderView.setItems(items);
            orderView.hideProgress();
        }
    }

    public OrderView getOrderView() {
        return orderView;
    }

}
