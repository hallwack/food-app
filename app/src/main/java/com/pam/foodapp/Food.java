package com.pam.foodapp;

import android.graphics.drawable.Drawable;

public class Food {
    String title;
    String description;
    int price;
    Drawable image;

    Food(String title, String description, int price, Drawable image) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Drawable getImage() {
        return image;
    }

    public int getPrice() {
        return price;
    }
}
