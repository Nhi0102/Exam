package com.example.myfood_ntpnhi;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myfood_ntpnhi.SQLite.Food_NTPNhi;

public class LoginActivity_NTPNhi extends AppCompatActivity {

    EditText etUsername, etPassword;
    Button btnLogin;
    TextView tvRegister;
    Food_NTPNhi dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_ntpnhi);

        etUsername = findViewById(R.id.etUsernameNTPNhi);
        etPassword = findViewById(R.id.etPasswordNTPNhi);
        btnLogin = findViewById(R.id.btnLoginNTPNhi);
        tvRegister = findViewById(R.id.tvRegisterNTPNhi);

        dbHelper = new Food_NTPNhi(this);

        btnLogin.setOnClickListener(v -> handleLogin());
        tvRegister.setOnClickListener(v -> {
            Intent i = new Intent(LoginActivity_NTPNhi.this, RegisterActivity_NTPNhi.class);
            startActivity(i);
        });
    }

    private void handleLogin() {
        String username = etUsername.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
            return;
        }

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM User WHERE Username=? AND Password=?", new String[]{username, password});

        if (cursor.moveToFirst()) {
            Toast.makeText(this, "Đăng nhập thành công!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LoginActivity_NTPNhi.this, MainActivity.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(this, "Sai tên đăng nhập hoặc mật khẩu", Toast.LENGTH_SHORT).show();
        }

        cursor.close();
        db.close();
    }
}
