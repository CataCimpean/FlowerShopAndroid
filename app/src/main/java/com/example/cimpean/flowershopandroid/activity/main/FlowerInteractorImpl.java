package com.example.cimpean.flowershopandroid.activity.main;

import android.os.Handler;

import com.example.cimpean.flowershopandroid.R;
import com.example.cimpean.flowershopandroid.model.Flower;
import com.example.cimpean.flowershopandroid.utils.Constants;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Cimpean on 4/23/2018.
 */
public class FlowerInteractorImpl implements FlowerInteractor {

    public static List<Flower> flowerList;
    @Override
    public void findItems(final OnFinishedListener listener) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                listener.onFinished(createListOfItems());
            }
        }, 1000);
    }

    private List<Flower> createListOfItems() {
        flowerList = Arrays.asList(new Flower(R.drawable.color_energy, Constants.FLOWER_COLOR_ENERGY, "Description1"),
                new Flower(R.drawable.fashion, Constants.FLOWER_FASHION, "Description2"),
                new Flower(R.drawable.flower_energy, Constants.FLOWER_ENERGY, "Description3"),
                new Flower(R.drawable.guzmania, Constants.FLOWER_GUZMANIA, "Description4"),
                new Flower(R.drawable.orchid_pink, Constants.FLOWER_ORCHID_PINK, "Description5"),
                new Flower(R.drawable.rainbow, Constants.FLOWER_RAINBOW, "Description6"),
                new Flower(R.drawable.red_tulips, Constants.FLOWER_RED_TULIPS, "Description7"),
                new Flower(R.drawable.spring_box, Constants.FLOWER_SPRING_BOX, "Description8"));

        return flowerList;
    }
}
