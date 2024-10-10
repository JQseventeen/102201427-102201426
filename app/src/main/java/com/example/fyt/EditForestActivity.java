package com.example.fyt;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class EditForestActivity extends AppCompatActivity {

    private EditText nicknameInput, introductionInput, tagsInput;
    private Button saveButton;
    private TextView tipsText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_forest);

        // 初始化视图
        nicknameInput = findViewById(R.id.nickname_input);
        introductionInput = findViewById(R.id.introduction_input);
        tagsInput = findViewById(R.id.tags_input);
        saveButton = findViewById(R.id.save_button);
        ImageButton backButton = findViewById(R.id.back_button);
        ImageButton addTagButton = findViewById(R.id.add_tag_button);

        // 初始化 TextView
        tipsText = findViewById(R.id.tips_text);


        // 加载之前保存的数据
        SharedPreferences sharedPreferences = getSharedPreferences("ForestDetails", MODE_PRIVATE);
        String savedNickname = sharedPreferences.getString("nickname", "");
        String savedIntroduction = sharedPreferences.getString("introduction", "");
        String savedTags = sharedPreferences.getString("tags", "");

        // 显示之前保存的数据
        nicknameInput.setText(savedNickname);
        introductionInput.setText(savedIntroduction);
        tagsInput.setText(savedTags);

        // 返回按钮点击事件
        backButton.setOnClickListener(view -> finish());

        // 标签添加按钮点击事件
        addTagButton.setOnClickListener(view -> {
            String tag = tagsInput.getText().toString();
            addTag(tag);
        });

        // 保存按钮点击事件
        saveButton.setOnClickListener(view -> saveData());
    }

    private void addTag(String tag) {
        if (!tag.isEmpty()) {
            // 将标签添加到 TextView 中
            tipsText.setText(tag);
        } else {
            Toast.makeText(this, "标签不能为空", Toast.LENGTH_SHORT).show();
        }
    }

    private void saveData() {
        String nickname = nicknameInput.getText().toString();
        String introduction = introductionInput.getText().toString();
        String tags = tagsInput.getText().toString();

        // 保存数据到 SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("ForestDetails", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("nickname", nickname);
        editor.putString("tags", tags);
        editor.putString("introduction", introduction);
        editor.apply();

        // 将数据传回给 ForestDetailsActivity
        Intent resultIntent = new Intent();
        resultIntent.putExtra("nickname", nickname);
        resultIntent.putExtra("introduction", introduction);
        resultIntent.putExtra("tags", tags);
        setResult(RESULT_OK, resultIntent);

        // 完成并返回
        finish();
    }
}