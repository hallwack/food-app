package com.pam.foodapp;

import android.content.Context;

import java.util.ArrayList;

public class FoodData {

    public static ArrayList<Food> getFoodData(Context context) {
        ArrayList<Food> foods = new ArrayList<Food>();

        foods.add(new Food("Batagor", "Ketika tidak ada bahu untuk bersandar, disitulah ada bataagor untuk didahar", 5000, context.getDrawable(R.drawable.batagor)));
        foods.add(new Food("Black Salad", "Pasti pedes", 7000, context.getDrawable(R.drawable.black_salad)));
        foods.add(new Food("Capuchino", "Ngopi dulu biar senja", 12000, context.getDrawable(R.drawable.cappuchino)));
        foods.add(new Food("Cheese Cake", "Buat yang mau ngemil tapi gamau gendud", 20000, context.getDrawable(R.drawable.cheesecake)));
        foods.add(new Food("Cireng", "Mayan ganjel perut", 4000, context.getDrawable(R.drawable.cireng)));
        foods.add(new Food("Donat", "Ganjel perut juga sekalian diet", 15000, context.getDrawable(R.drawable.donut)));
        foods.add(new Food("Kopi Hitam", "Yang mau sesenjaan tapi dana tidak memadai", 3000, context.getDrawable(R.drawable.kopi_hitam)));
        foods.add(new Food("Mie Goreng", "Pake nasi biar seubeuh", 7000, context.getDrawable(R.drawable.mie_goreng)));

        return foods;
    }
}
