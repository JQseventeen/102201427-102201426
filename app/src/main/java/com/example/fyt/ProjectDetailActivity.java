package com.example.fyt;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ProjectDetailActivity extends AppCompatActivity {

    private TextView projectNameText;
    private TextView projectMemberText;
    private TextView projectDescriptionText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_detail);

        projectNameText = findViewById(R.id.projectName);
        projectMemberText = findViewById(R.id.projectMember);
        projectDescriptionText = findViewById(R.id.projectDescription);

        // 获取创建项目页面传过来的数据
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String projectName = extras.getString("projectName");
            String projectMember = extras.getString("projectMember");
            String projectDescription = extras.getString("projectDescription");

            projectNameText.setText(projectName);
            projectMemberText.setText(projectMember);
            projectDescriptionText.setText(projectDescription);
        }

        // 编辑按钮
        findViewById(R.id.editButton).setOnClickListener(v -> {
            // 这里可添加编辑逻辑
        });

        // 返回仓库按钮
        findViewById(R.id.backToStoreButton).setOnClickListener(v -> {
            // 延迟或销毁活动以返回仓库
            finish();
        });
    }
}