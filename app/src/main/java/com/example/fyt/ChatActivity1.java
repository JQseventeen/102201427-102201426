package com.example.fyt;

import android.os.Bundle;
import android.widget.Button;
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
import androidx.appcompat.app.AppCompatActivity;

public class ChatActivity1 extends AppCompatActivity {

    private ListView listViewProjects;
    private Button buttonHome;
    private Button buttonChat;
    private Button buttonMy;
    private Button buttonWarehouse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_chat1);

        buttonHome = findViewById(R.id.button_home);
        buttonChat = findViewById(R.id.button_chat);
        buttonMy = findViewById(R.id.button_my);
        buttonWarehouse = findViewById(R.id.button_warehouse);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.chat1), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}