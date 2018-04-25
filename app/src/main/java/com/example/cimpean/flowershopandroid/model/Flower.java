package com.example.cimpean.flowershopandroid.model;

/**
 * Created by Cimpean on 4/23/2018.
 */
public class Flower {


    private int resIdThumbnail;
    private String name;
    private String description;


    public Flower(int resIdThumbnail, String name, String description) {
        this.resIdThumbnail = resIdThumbnail;
        this.name = name;
        this.description = description;
    }

    public int getResIdThumbnail() {
        return resIdThumbnail;
    }

    public void setResIdThumbnail(int resIdThumbnail) {
        this.resIdThumbnail = resIdThumbnail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
