package com.example.fyt;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChatActivity1 extends AppCompatActivity {


    private Button buttonHome;
    private Button buttonChat;
    private Button buttonMain;
    private Button buttonWarehouse;
    private ListView messageListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_chat1);

        // 初始化组件
        buttonHome = findViewById(R.id.button_home);
        buttonChat = findViewById(R.id.button_chat);
        buttonMain = findViewById(R.id.button_main);
        buttonWarehouse = findViewById(R.id.button_warehouse);

        buttonMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChatActivity1.this, TeamActivity.class);
                startActivity(intent);
            }
        });

        buttonChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到聊天
                Intent intent = new Intent(ChatActivity1.this, ChatActivity1.class);
                startActivity(intent);
            }
        });

        buttonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 注意：如果buttonHome真的是指向“我的”页面，
                Intent intent = new Intent(ChatActivity1.this, HomeActivity.class); // 或者 MyActivity.class
                startActivity(intent);
            }
        });

        buttonWarehouse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //仓库
                Intent intent = new Intent(ChatActivity1.this, StoreActivity.class);
                startActivity(intent);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.chat1), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        messageListView = findViewById(R.id.message_list);

        // 设置消息数据
        List<Map<String, String>> messageData = new ArrayList<>();
        messageData.add(createMessage("儿子", "好了没？", "5:00"));
        messageData.add(createMessage("李四", "七夕快乐！", "5:20"));
        messageData.add(createMessage("神金", "院楼，速来。", "10:00"));
        messageData.add(createMessage("实验室", "哈哈哈哈哈哈", "18:00"));
        messageData.add(createMessage("学弟", "这个对吗？", "19:50"));

        // 设置适配器
        String[] from = {"name", "message", "time"};
        int[] to = {R.id.contact_name, R.id.message_text, R.id.message_time};

        SimpleAdapter adapter = new SimpleAdapter(this, messageData,
                R.layout.item_chat1, from, to);
        messageListView.setAdapter(adapter);
    }
    private HashMap<String, String> createMessage(String name, String message, String time) {
        HashMap<String, String> item = new HashMap<>();
        item.put("name", name);
        item.put("message", message);
        item.put("time", time);
        return item;
    }
}