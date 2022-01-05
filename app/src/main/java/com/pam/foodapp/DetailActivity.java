package com.pam.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        int selectedItem = getIntent().getIntExtra("id", -1);

        if (selectedItem != -1) {
            Food foods = FoodData.getFoodData(getApplicationContext()).get(selectedItem);

            getSupportActionBar().setTitle(foods.getTitle());

            ImageView imageView = findViewById(R.id.food_image);
            TextView titleView = findViewById(R.id.food_name);
            TextView priceView = findViewById(R.id.food_price);
            TextView descriptionView = findViewById(R.id.food_description);

            imageView.setBackground(foods.getImage());
            titleView.setText(foods.getTitle());
            priceView.setText("Rp. " + String.valueOf(foods.getPrice()));
            descriptionView.setText(foods.getDescription());
        }
    }
}