package com.pam.foodapp;

import android.content.Context;

import java.util.ArrayList;

public class FoodData {

    public static ArrayList<Food> getFoodData(Context context) {
        ArrayList<Food> foods = new ArrayList<Food>();

        foods.add(new Food(1, "Batagor", "Ketika tidak ada bahu untuk bersandar, disitulah ada bataagor untuk didahar", 5000, "batagor"));
        foods.add(new Food(2, "Black Salad", "Pasti pedes", 7000, "black_salad"));
        foods.add(new Food(3, "Capuchino", "Ngopi dulu biar senja", 12000, "cappuchino"));
        foods.add(new Food(4, "Cheese Cake", "Buat yang mau ngemil tapi gamau gendud", 20000, "cheesecake"));
        foods.add(new Food(5, "Cireng", "Mayan ganjel perut", 4000, "cireng"));
        foods.add(new Food(6, "Donat", "Ganjel perut juga sekalian diet", 15000, "donut"));
        foods.add(new Food(7, "Kopi Hitam", "Yang mau sesenjaan tapi dana tidak memadai", 3000, "kopi_hitam"));
        foods.add(new Food(8, "Mie Goreng", "Pake nasi biar seubeuh", 7000, "mie_goreng"));

        return foods;
    }
}
