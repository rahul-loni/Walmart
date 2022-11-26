package com.example.walmart.model;

public class Items {
    private  int id;
    private String name;
    private String price;
    private String dis;
    private byte[] image;

    public Items(int id, String name, String price, String dis, byte[] image) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.dis = dis;
        this.image = image;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDis() {
        return dis;
    }

    public void setDis(String dis) {
        this.dis = dis;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
