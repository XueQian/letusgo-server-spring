package com.thoughtworks.entity;

public class Item {

    private int itemId;
    private String barcode;
    private String itemname;
    private String unitname;
    private double price;


    public Item(){

    }

    public Item( String barcode, String itemname, String unitname, double price) {
        this.barcode = barcode;
        this.itemname = itemname;
        this.unitname = unitname;
        this.price = price;
    }

    public Item(int itemId, String barcode, String itemname, String unitname, double price) {
        this.setItemId(itemId);
        this.barcode = barcode;
        this.itemname = itemname;
        this.unitname = unitname;
        this.price = price;
    }


    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public String getUnitname() {
        return unitname;
    }

    public void setUnitname(String unitname) {
        this.unitname = unitname;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + itemId +
                ", barcode='" + barcode + '\'' +
                ", itemname='" + itemname + '\'' +
                ", unitname='" + unitname + '\'' +
                ", price=" + price +

                '}';
    }
}
