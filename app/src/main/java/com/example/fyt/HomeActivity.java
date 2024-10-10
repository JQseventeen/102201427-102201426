package com.example.fyt;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HomeActivity extends AppCompatActivity {

    private Button buttonHome;
    private Button buttonChat;
    private Button buttonMain;
    private Button buttonWarehouse;
    private ImageButton firstButton;
    private ImageButton secondButton;
    private ImageButton thirdButton;
    private ImageButton fourthButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);

        // 初始化组件
        buttonHome = findViewById(R.id.button_home);
        buttonChat = findViewById(R.id.button_chat);
        buttonMain = findViewById(R.id.button_main);
        buttonWarehouse = findViewById(R.id.button_warehouse);

        firstButton = findViewById(R.id.first);
        secondButton = findViewById(R.id.second);
        thirdButton = findViewById(R.id.third);
        fourthButton = findViewById(R.id.fourth);

        // 设置点击监听器
        firstButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳到人才林编辑
                Intent intent = new Intent(HomeActivity.this, ForestDetailsActivity.class);
                startActivity(intent);
            }
        });
        secondButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳到设置帮助
                Intent intent = new Intent(HomeActivity.this, SettingsHelpActivity.class);
                startActivity(intent);
            }
        });
        thirdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳到聊天
                Intent intent = new Intent(HomeActivity.this, ChatActivity1.class);
                startActivity(intent);
            }
        });
        fourthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳到认证
                Intent intent = new Intent(HomeActivity.this, CertifyDetailsActivity.class);
                startActivity(intent);
            }
        });

        //底部导航栏
        buttonMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //首页
                Intent intent = new Intent(HomeActivity.this, TeamActivity.class);
                startActivity(intent);
            }
        });

        buttonChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到聊天
                Intent intent = new Intent(HomeActivity.this, ChatActivity1.class);
                startActivity(intent);
            }
        });

        buttonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 指向“我的”页面
                Intent intent = new Intent(HomeActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        buttonWarehouse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //仓库
                Intent intent = new Intent(HomeActivity.this, StoreActivity.class);
                startActivity(intent);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.home), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}