package com.thoughtworks.entity;

public class CartItemDb {

    private int id;
    private String barcode;
    private double count;

    public CartItemDb(int id, String barcode, double count) {
        this.id = id;
        this.barcode = barcode;
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public double getCount() {
        return count;
    }

    public void setCount(double count) {
        this.count = count;
    }
}
