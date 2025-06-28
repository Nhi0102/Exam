package com.example.myfood_ntpnhi.SQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class Food_NTPNhi extends SQLiteOpenHelper {
    public static final String DB_NAME = "Food_XXX.db";
    public static final int DB_VERSION = 1;

    public Food_NTPNhi(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE User (" +
                "UserID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "Name TEXT," +
                "Gender TEXT," +
                "Date_of_birth TEXT," +
                "Phone TEXT," +
                "Username TEXT," +
                "Password TEXT)");


        db.execSQL("CREATE TABLE Restaurant (" +
                "ResID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "Name TEXT," +
                "Address TEXT," +
                "Phone TEXT," +
                "Image TEXT)");


        db.execSQL("CREATE TABLE Food (" +
                "FoodID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "Name TEXT," +
                "Type TEXT," +
                "Description TEXT," +
                "Image TEXT," +
                "ResID INTEGER," +
                "FOREIGN KEY(ResID) REFERENCES Restaurant(ResID))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS User");
        db.execSQL("DROP TABLE IF EXISTS Restaurant");
        db.execSQL("DROP TABLE IF EXISTS Food");
        onCreate(db);
    }
}
