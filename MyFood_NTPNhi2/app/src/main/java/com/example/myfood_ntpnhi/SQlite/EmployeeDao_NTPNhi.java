package com.example.myfood_ntpnhi.SQLite;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.myfood_ntpnhi.Model.Employee_NTPNhi;
import com.example.myfood_ntpnhi.SQLite.Food_NTPNhi;


public class EmployeeDao_NTPNhi {
    private final SQLiteDatabase db;

    public EmployeeDao_NTPNhi(Context context) {
        Food_NTPNhi helper = new Food_NTPNhi(context);
        db = helper.getWritableDatabase();
    }

    public boolean insert(Employee_NTPNhi emp) {
        ContentValues values = new ContentValues();
        values.put("Username", emp.getUsername());
        values.put("Password", emp.getPassword());
        long result = db.insert("User", null, values);
        return result != -1;
    }

    public boolean checkLogin(String username, String password) {
        Cursor cursor = db.rawQuery(
                "SELECT * FROM User WHERE Username=? AND Password=?",
                new String[]{username, password}
        );
        return cursor.getCount() > 0;
    }
}

