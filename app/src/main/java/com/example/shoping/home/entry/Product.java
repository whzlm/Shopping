package com.example.shoping.home.entry;

public class Product {
    private int id;
    private String name;
    private double price;
    private double oldPrice;
    private String img;
    private int total;
    private String type;

    public Product(){}
    public Product(int id, String name, double oldPrice, double price, String img, int total, String type) {
        this.id = id;
        this.name = name;
        this.oldPrice = oldPrice;
        this.price = price;
        this.img = img;
        this.total = total;
        this.type = type;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(double oldPrice) {
        this.oldPrice = oldPrice;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
