package com.example.shoping.home.entry;

public class Recommend {
    private int img;
    private String title;
    private int price;

    public Recommend(){}

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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Recommend(int img, String title, int price) {
        this.img = img;
        this.title = title;
        this.price = price;
    }
}
