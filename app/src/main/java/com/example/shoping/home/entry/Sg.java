package com.example.shoping.home.entry;

public class Sg {

    private int sgimg;
    private int sgprice;
    private int price;

    public Sg(){}

    public Sg(int sgimg, int sgprice, int price) {
        this.sgimg = sgimg;
        this.sgprice = sgprice;
        this.price = price;
    }

    public int getSgimg() {
        return sgimg;
    }

    public void setSgimg(int sgimg) {
        this.sgimg = sgimg;
    }

    public int getSgprice() {
        return sgprice;
    }

    public void setSgprice(int sgprice) {
        this.sgprice = sgprice;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
