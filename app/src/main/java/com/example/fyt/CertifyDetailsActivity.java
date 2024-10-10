package com.example.fyt;

import android.content.Intent;
import android.os.Bundle;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class CertifyDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_certify_details);

        ImageButton backbutton = findViewById(R.id.details_back_button);
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CertifyDetailsActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        Button certifybutton = findViewById(R.id.confirm_certify_button);
        certifybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CertifyDetailsActivity.this, CertifyActivity.class);
                startActivity(intent);
            }
        });

        // 读取 SharedPreferences 中的数据
        SharedPreferences sharedPreferences = getSharedPreferences("user_info", MODE_PRIVATE);
        String identity = sharedPreferences.getString("identity", "未知身份");
        String name = sharedPreferences.getString("name", "默认姓名");
        String school = sharedPreferences.getString("school", "默认学校");
        String schoolNumber = sharedPreferences.getString("schoolNumber", "默认学号");

        // 设置到 TextView 中
        TextView titleTextView = findViewById(R.id.titleTextView);
        TextView schoolTextView = findViewById(R.id.schoolTextView);
        TextView nameTextView = findViewById(R.id.nameTextView);
        TextView schoolNumberTextView = findViewById(R.id.schoolNumberTextView);
        TextView shenfenTextView = findViewById(R.id.shenfenTextView);

        titleTextView.setText("身份信息");
        schoolTextView.setText("学校: " + school);
        nameTextView.setText("姓名: " + name);
        schoolNumberTextView.setText("学号: " + schoolNumber);
        shenfenTextView.setText("身份: " + identity);
    }
}