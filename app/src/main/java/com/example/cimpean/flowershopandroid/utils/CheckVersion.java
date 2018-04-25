package com.example.cimpean.flowershopandroid.utils;

import android.os.StrictMode;

/**
 * Created by Cimpean on 4/25/2018.
 */
public class CheckVersion {


    public static void checkSDKVersion() {
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
    }
}
