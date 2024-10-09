package com.example.fyt;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class AllStoreActivity extends AppCompatActivity {

    private ListView listViewItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_all);

        listViewItems = findViewById(R.id.listView_items);

        // Sample data
        String[] items = {"无人机定位系统", "潜水艇定位系统", "定日镜场", "阿基米德螺线板宽龙", "基于层次分析法的集..."};
        String[] subtitles = {"Python", "Java", "C++", "C/C++", "数据结构"};

        // Combine data for display purposes
        String[] displayItems = new String[items.length];
        for (int i = 0; i < items.length; i++) {
            displayItems[i] = items[i] + "\n" + subtitles[i];
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.list_item, R.id.text1, displayItems);
        listViewItems.setAdapter(adapter);

        // Handle item clicks if needed
        // listViewItems.setOnItemClickListener((parent, view, position, id) -> { ... });
    }

    // Method to handle back button click
    public void goBack(View view) {
        Intent intent = new Intent(AllStoreActivity.this, TeamActivity.class);
        startActivity(intent);
        finish(); // Optional: Finish current activity if you don't want to keep it in the back stack
    }
}