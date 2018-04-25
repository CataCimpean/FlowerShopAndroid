package com.example.cimpean.flowershopandroid.activity.main;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.example.cimpean.flowershopandroid.activity.order.OrderActivity;
import com.example.cimpean.flowershopandroid.model.Flower;

import java.util.List;

/**
 * Created by Cimpean on 4/23/2018.
 */
public class MainPresenterImpl implements MainPresenter, FlowerInteractorImpl.OnFinishedListener  {


    private MainView mainView;
    private FlowerInteractor findItemsInteractor;

    public MainPresenterImpl(MainView mainView, FlowerInteractor findItemsInteractor) {
        this.mainView = mainView;
        this.findItemsInteractor = findItemsInteractor;
    }

    @Override
    public void onResume() {

        if (mainView != null) {
            mainView.showProgress();
        }

        findItemsInteractor.findItems(this);
    }

    @Override
    public void onItemClicked(int position,Context context,Activity activity) {

        if (mainView != null) {
            mainView.showMessage(String.format("Position %d clicked", position + 1));

            Intent intent = new Intent();
            intent.putExtra("FlowerName",FlowerInteractorImpl.flowerList.get(position).getName());

            intent.setClass(context,OrderActivity.class);
            activity.startActivity(intent);

        }
    }

    @Override
    public void onDestroy() {

        mainView = null;
    }

    @Override
    public void onFinished(List<Flower> items) {
        if (mainView != null) {
            mainView.setItems(items);
            mainView.hideProgress();
        }
    }

    public MainView getMainView() {
        return mainView;
    }
}
