package com.example.fyt;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.fyt.ui.login.LoginActivity;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_first);

        // 设置窗口内边距（如果需要）
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.first), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // 使用 Handler 延迟 1000 毫秒（1 秒）后启动 LoginActivity
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(FirstActivity.this, LoginActivity.class);
            startActivity(intent);
            finish(); // 结束当前 Activity
        }, 2000);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.first), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}