package com.example.fyt;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ForestDetailsActivity extends AppCompatActivity {

    private TextView forestDetailsText;
    private static final int EDIT_FOREST_REQUEST_CODE = 1;
    private TextView nicknameText, tagsText, introductionText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forest_details);

        // 初始化视图
        nicknameText = findViewById(R.id.nickname_text);
        tagsText = findViewById(R.id.tags_text);
        introductionText = findViewById(R.id.introduction_text);
        ImageButton backButton = findViewById(R.id.button_back);

        // 返回按钮点击事件
        backButton.setOnClickListener(view -> finish());

        // 从 SharedPreferences 中恢复数据
        SharedPreferences sharedPreferences = getSharedPreferences("ForestDetails", MODE_PRIVATE);
        String nickname = sharedPreferences.getString("nickname", "默认昵称");
        String tags = sharedPreferences.getString("tags", "默认标签");
        String introduction = sharedPreferences.getString("introduction", "默认简介");

        // 更新 UI 显示
        nicknameText.setText("昵称：" + nickname);
        tagsText.setText("标签：" + tags);
        introductionText.setText("简介：" + introduction);

        // 处理编辑按钮点击事件
        Button editButton = findViewById(R.id.button_edit);
        editButton.setOnClickListener(view -> {
            Intent intent = new Intent(ForestDetailsActivity.this, EditForestActivity.class);
            startActivityForResult(intent, 1);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK) {
            String nickname = data.getStringExtra("nickname");
            String introduction = data.getStringExtra("introduction");
            String tags = data.getStringExtra("tags");

            // 更新 UI 显示
            nicknameText.setText("昵称：" + nickname);
            tagsText.setText("标签：" + tags);
            introductionText.setText("简介：" + introduction);

            // 保存数据到 SharedPreferences
            SharedPreferences sharedPreferences = getSharedPreferences("ForestDetails", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("nickname", nickname);
            editor.putString("tags", tags);
            editor.putString("introduction", introduction);
            editor.apply();
        }
    }
}