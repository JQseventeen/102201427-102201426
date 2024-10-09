package com.example.fyt;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class GeniusForestActivity extends AppCompatActivity {

    private ListView listViewPeople;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genius_forest);

        listViewPeople = findViewById(R.id.listView_people);

        // 示例数据
        String[] names = {"张三（学生）", "李四（学生）", "郑五（助教）", "孙九（老师）"};
        String[] descriptions = {
                "我叫张三，来自22级信息安全专业。",
                "我叫李四，比张三大一岁。",
                "我叫郑五，呜呜呜 T_T",
                "你好。"
        };

        // 组合显示的数据
        String[] displayItems = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            displayItems[i] = names[i] + "\n" + descriptions[i];
        }

        // 使用自定义的布局适配器
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.list_item, R.id.text1, displayItems);
        listViewPeople.setAdapter(adapter);
    }

    // 返回按钮的点击事件
    public void goBack(View view) {
        Intent intent = new Intent(GeniusForestActivity.this, TeamActivity.class);
        startActivity(intent);
        finish(); // 可选：如果不需要将当前活动保留在返回栈中，可以调用此方法
    }
}