package com.example.cimpean.flowershopandroid.activity.main;

import com.example.cimpean.flowershopandroid.model.Flower;

import java.util.List;

/**
 * Created by Cimpean on 4/23/2018.
 */
public interface FlowerInteractor {


    interface OnFinishedListener {
        void onFinished(List<Flower> items);
    }

    void findItems(OnFinishedListener listener);


}
