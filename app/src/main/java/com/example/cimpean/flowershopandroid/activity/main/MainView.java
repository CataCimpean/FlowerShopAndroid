package com.example.cimpean.flowershopandroid.activity.main;

import com.example.cimpean.flowershopandroid.model.Flower;

import java.util.List;

/**
 * Created by Cimpean on 4/23/2018.
 */
public interface MainView {

    void showProgress();
    void hideProgress();
    void setItems(List<Flower> items);
    void showMessage(String message);

}
