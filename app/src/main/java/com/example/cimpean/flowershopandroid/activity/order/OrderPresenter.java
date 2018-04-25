package com.example.cimpean.flowershopandroid.activity.order;

import android.view.View;

/**
 * Created by Cimpean on 4/24/2018.
 */
public interface OrderPresenter {

    void onResume();
    void onItemClicked(View adapter, int position);
    void onDestroy();
}
