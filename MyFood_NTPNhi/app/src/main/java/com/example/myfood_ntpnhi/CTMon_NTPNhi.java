package com.example.myfood_ntpnhi;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CTMon_NTPNhi extends AppCompatActivity {

    TextView tvGiaNTPNhi;
    RadioGroup rgSizeNTPNhi;
    RadioButton rbSmallNTPNhi, rbLargeNTPNhi;
    ImageButton btnGioHangNTPNhi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_ntpnhi);

        ImageView imgMonAnNTPNhi = findViewById(R.id.imbanhmi_NTPNhi);
        TextView tvTenMonNTPNhi = findViewById(R.id.tvTenMon_NTPNhi);
        tvGiaNTPNhi = findViewById(R.id.tvGiaNTPNhi);
        TextView tvMoTaNTPNhi = findViewById(R.id.tvMoTaNTPNhi);
        TextView tvDiaChiNTPNhi = findViewById(R.id.tvDiaChiNTPNhi);
        rgSizeNTPNhi = findViewById(R.id.rgSize_NTPNhi);
        rbSmallNTPNhi = findViewById(R.id.rbSmall_NTPNhi);
        rbLargeNTPNhi = findViewById(R.id.rbLarge_NTPNhi);
        btnGioHangNTPNhi = findViewById(R.id.btnGioHang_NTPNhi);

        imgMonAnNTPNhi.setImageResource(R.drawable.banhmi);
        tvTenMonNTPNhi.setText("Bánh mì đặc biệt");
        tvGiaNTPNhi.setText("Giá: 25.000 VNĐ");
        tvMoTaNTPNhi.setText("Mô tả: Bánh mì giòn rụm, nhân đầy đặn gồm thịt nướng, pate, dưa leo, rau thơm và nước sốt đặc biệt.");
        tvDiaChiNTPNhi.setText("Địa chỉ: 123 Nguyễn Văn Cừ, Quận 5, TP.HCM");

        rgSizeNTPNhi.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.rbSmall_NTPNhi) {
                tvGiaNTPNhi.setText("Giá: 25.000 VNĐ");
            } else if (checkedId == R.id.rbLarge_NTPNhi) {
                tvGiaNTPNhi.setText("Giá: 35.000 VNĐ");
            }
        });

        btnGioHangNTPNhi.setOnClickListener(v -> {
            Toast.makeText(CTMon_NTPNhi.this, "Đã thêm vào giỏ hàng!", Toast.LENGTH_SHORT).show();
        });
    }
}