package com.example.cimpean.flowershopandroid.activity.order;

import android.content.Context;
import android.os.Handler;
import android.util.Log;

import com.example.cimpean.flowershopandroid.model.Order;
import com.example.cimpean.flowershopandroid.utils.JSONAsyncTask;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by Cimpean on 4/23/2018.
 */
public class OrderInteractorImpl implements OrderInteractor {


    @Override
    public void findItems(final OrderInteractor.OnFinishedListener listener,final String typeOfFlower, final Context context, final OrderView orderView) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                try {
                    listener.onFinished(getListOfOrders(typeOfFlower, context,orderView));
                } catch (ExecutionException e) {
                    Log.d("ExecutionException","exception");
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    Log.d("ExecutionException","exception");
                    e.printStackTrace();
                }
            }
        }, 1000);
    }

    private List<Order> getListOfOrders(final String flowerName, final Context context,OrderView orderView) throws ExecutionException, InterruptedException {
       return new JSONAsyncTask(context,orderView).execute(flowerName).get();
    }



}
