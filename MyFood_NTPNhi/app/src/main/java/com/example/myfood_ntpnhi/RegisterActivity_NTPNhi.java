package com.example.myfood_ntpnhi;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.example.myfood_ntpnhi.Model.Employee_NTPNhi;
import com.example.myfood_ntpnhi.SQLite.EmployeeDao_NTPNhi;

public class RegisterActivity_NTPNhi extends AppCompatActivity {
    private EditText edtUser, edtPass, edtRePass;
    private ImageButton btnSubmit;
    private EmployeeDao_NTPNhi employeeDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_ntpnhi);


        employeeDao = new EmployeeDao_NTPNhi(this);


        edtUser = findViewById(R.id.etUsernameNTPNhi);
        edtPass = findViewById(R.id.etPasswordNTPNhi);
        edtRePass = findViewById(R.id.etRePasswordNTPNhi);
        btnSubmit = findViewById(R.id.btnSubmitNTPNhi);

        btnSubmit.setOnClickListener(v -> {
            String user = edtUser.getText().toString().trim();
            String pass = edtPass.getText().toString().trim();
            String repass = edtRePass.getText().toString().trim();

            if (user.isEmpty() || pass.isEmpty() || repass.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!pass.equals(repass)) {
                Toast.makeText(this, "Mật khẩu không khớp", Toast.LENGTH_SHORT).show();
                return;
            }

            Employee_NTPNhi employee = new Employee_NTPNhi(user, pass);
            boolean result = employeeDao.insert(employee);
            if (result) {
                Toast.makeText(this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(RegisterActivity_NTPNhi.this, LoginActivity_NTPNhi.class));
                finish();
            } else {
                Toast.makeText(this, "Đăng ký thất bại", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
