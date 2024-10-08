package com.example.fyt;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class EditForestActivity extends AppCompatActivity {

    private EditText nicknameInput;
    private EditText introductionInput;
    private EditText tagsInput;
    private Button saveButton;

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
        // 在此处插入逻辑以添加标签
        Toast.makeText(this, "标签添加: " + tag, Toast.LENGTH_SHORT).show();
    }

    private void saveData() {
        String nickname = nicknameInput.getText().toString();
        String introduction = introductionInput.getText().toString();
        String tags = tagsInput.getText().toString();

        // 在此处插入保存数据的逻辑
        Toast.makeText(this, "信息已保存", Toast.LENGTH_SHORT).show();
    }
}
