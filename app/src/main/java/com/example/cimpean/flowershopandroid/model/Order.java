package com.example.cimpean.flowershopandroid.model;

import java.util.Date;

/**
 * Created by Cimpean on 4/23/2018.
 */
public class Order {

    private int id;
    private String deliver_to;
    private String flowerType;
    private Date delivery_date;
    private String address;
    private Float price;

    public Order(int id, String deliver_to, String flowerType, Date delivery_date, String address, Float price) {
        this.id = id;
        this.deliver_to = deliver_to;
        this.flowerType = flowerType;
        this.delivery_date = delivery_date;
        this.address = address;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeliver_to() {
        return deliver_to;
    }

    public void setDeliver_to(String deliver_to) {
        this.deliver_to = deliver_to;
    }

    public String getFlowerType() {
        return flowerType;
    }

    public void setFlowerType(String flowerType) {
        this.flowerType = flowerType;
    }

    public Date getDelivery_date() {
        return delivery_date;
    }

    public void setDelivery_date(Date delivery_date) {
        this.delivery_date = delivery_date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
