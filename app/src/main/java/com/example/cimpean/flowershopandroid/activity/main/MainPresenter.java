package com.example.cimpean.flowershopandroid.activity.main;

import android.app.Activity;
import android.content.Context;

/**
 * Created by Cimpean on 4/23/2018.
 */
public interface MainPresenter {

    void onResume();
    void onItemClicked(int position, Context context, Activity activity);
    void onDestroy();


}
