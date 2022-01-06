package com.pam.foodapp;

public class Food {
    int id;
    String title;
    String description;
    int price;
    String image;

    Food(int id, String title, String description, int price, String image) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public int getPrice() {
        return price;
    }
}
