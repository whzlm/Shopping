package com.example.shoping.home.entry;

public class Hot {
    private int img;
    private String title;
    private float price;

    public  Hot(){}

    public Hot(int img, String title, float price) {
        this.img = img;
        this.title = title;
        this.price = price;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
