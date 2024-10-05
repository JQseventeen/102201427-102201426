package com.example.fyt;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import androidx.appcompat.app.AppCompatActivity;

public class TeamActivity extends AppCompatActivity {

    private Button buttonProjects;
    private Button buttonTalents;
    private ListView listViewProjects;
    private Button buttonHome;
    private Button buttonChat;
    private Button buttonMain;
    private Button buttonWarehouse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainpage);

        // 初始化组件
        buttonProjects = findViewById(R.id.button_projects);
        buttonTalents = findViewById(R.id.button_talents);
        listViewProjects = findViewById(R.id.listView_projects);
        buttonHome = findViewById(R.id.button_home);
        buttonChat = findViewById(R.id.button_chat);
        buttonMain = findViewById(R.id.button_main);
        buttonWarehouse = findViewById(R.id.button_warehouse);



        // 设置点击事件监听器
        buttonProjects.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 跳转到项目总库页面
            }
        });

        buttonTalents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 跳转到人才林页面
            }
        });

        buttonMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TeamActivity.this, TeamActivity.class);
                startActivity(intent);
            }
        });

        buttonChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到聊天
                Intent intent = new Intent(TeamActivity.this, ChatActivity1.class);
                startActivity(intent);
            }
        });

        buttonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 注意：如果buttonHome真的是指向“我的”页面，
                Intent intent = new Intent(TeamActivity.this, HomeActivity.class); // 或者 MyActivity.class
                startActivity(intent);
            }
        });

        buttonWarehouse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //仓库
                Intent intent = new Intent(TeamActivity.this, StoreActivity.class);
                startActivity(intent);
            }
        });

        // 初始化项目列表
        initializeProjectsList();
    }

    private void initializeProjectsList() {
        // 这里添加你的项目列表初始化代码
    }
}