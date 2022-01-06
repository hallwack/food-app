package com.pam.foodapp;

import android.app.WallpaperManager;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class DataSource extends SQLiteOpenHelper {
    private static final String DBNAME = "foodapp";
    private static final int DBVER = 1;
    private Context context;

    public DataSource(Context context) {
        super(context, DBNAME, null, DBVER);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE menu (" +
                "id INTEGER PRIMARY KEY NOT NULL, " +
                "name STRING NOT NULL, " +
                "price INTEGER NOT NULL, " +
                "description STRING NOT NULL, " +
                "image STRING NOT NULL" +
                ")";
        sqLiteDatabase.execSQL(query);

        Log.d("SQLTAG", "onCreate" + query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS menu");
        onCreate(sqLiteDatabase);
    }

    public void insertDummyData() {
        ArrayList<Food> foods = new ArrayList<Food>();

        foods.add(new Food(1, "Batagor", "Ketika tidak ada bahu untuk bersandar, disitulah ada bataagor untuk didahar", 5000, "batagor"));
        foods.add(new Food(2, "Black Salad", "Pasti pedes", 7000, "black_salad"));
        foods.add(new Food(3, "Capuchino", "Ngopi dulu biar senja", 12000, "cappuchino"));
        foods.add(new Food(4, "Cheese Cake", "Buat yang mau ngemil tapi gamau gendud", 20000, "cheesecake"));
        foods.add(new Food(5, "Cireng", "Mayan ganjel perut", 4000, "cireng"));
        foods.add(new Food(6, "Donat", "Ganjel perut juga sekalian diet", 15000, "donut"));
        foods.add(new Food(7, "Kopi Hitam", "Yang mau sesenjaan tapi dana tidak memadai", 3000, "kopi_hitam"));
        foods.add(new Food(8, "Mie Goreng", "Pake nasi biar seubeuh", 7000, "mie_goreng"));

        for (Food food : foods) {

        }
    }

    public void insertData(Food food) {
        ContentValues contentValues = new ContentValues();

        contentValues.put("id", food.getId());
        contentValues.put("name", food.getTitle());
        contentValues.put("price", food.getPrice());
        contentValues.put("description", food.getDescription());
        contentValues.put("image", food.getImage());

        SQLiteDatabase db = this.getWritableDatabase();
        long res = db.insert("menu", null, contentValues);
        Log.d("SQLTAG", res + " is inserted");
        db.close();
    }

    public ArrayList<Food> readData() {
        String query = "SELECT * FROM menu";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor result = db.rawQuery(query, null);

        ArrayList<Food> food = new ArrayList<>();

        while (result.moveToNext()) {
            Log.d("SQLTAG", "Data: " + result.getString(1).toString());
            food.add(new Food(result.getInt(0), result.getString(1), result.getString(2), result.getInt(3), result.getString(4)));
        }

        result.close();

        return food;
    }

    public Food readById(int id) {
        String query = "SELECT * FROM menu WHERE id = " + id;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor result = db.rawQuery(query, null);

        Food food = null;

        if (result.moveToFirst()) {
            food = new Food(result.getInt(0), result.getString(1), result.getString(2), result.getInt(3), result.getString(4));
        }

        result.close();

        return food;
    }
}
