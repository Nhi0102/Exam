package com.example.myfood_ntpnhi;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ImageView imBanhMi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        imBanhMi = findViewById(R.id.imbanhmi_NTPNhi);


        imBanhMi.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CTMon_NTPNhi.class);
            startActivity(intent);
        });
    }
}
