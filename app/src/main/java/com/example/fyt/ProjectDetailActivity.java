package com.example.fyt;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ProjectDetailActivity extends AppCompatActivity {

    private TextView projectNameText;
    private TextView projectMemberText;
    private TextView projectDescriptionText;
    private Button backToStoreButton;
    private Button editProjectButton;
    private Button deleteProjectButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_detail);

        projectNameText = findViewById(R.id.projectName);
        projectMemberText = findViewById(R.id.projectMember);
        projectDescriptionText = findViewById(R.id.projectDescription);
        backToStoreButton = findViewById(R.id.backToStoreButton);
        editProjectButton = findViewById(R.id.editProjectButton);
        deleteProjectButton = findViewById(R.id.deleteProjectButton);

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

        // 设置返回按钮点击事件
        backToStoreButton.setOnClickListener(view -> finish());

        // 设置编辑项目按钮点击事件
        editProjectButton.setOnClickListener(view -> {
            // 跳转到编辑项目页面
            Intent intent = new Intent(ProjectDetailActivity.this, EditProjectActivity.class);
            intent.putExtra("projectName", projectNameText.getText().toString());
            intent.putExtra("projectMember", projectMemberText.getText().toString());
            intent.putExtra("projectDescription", projectDescriptionText.getText().toString());
            startActivity(intent);
        });

        // 设置删除项目按钮点击事件
        deleteProjectButton.setOnClickListener(view -> {
            // 执行删除项目的逻辑
            new AlertDialog.Builder(ProjectDetailActivity.this)
                    .setTitle("删除项目")
                    .setMessage("确定要删除此项目吗？")
                    .setPositiveButton("删除", (dialog, which) -> {
                        // 执行删除操作，这里可以添加删除逻辑
                        Toast.makeText(ProjectDetailActivity.this, "项目已删除", Toast.LENGTH_SHORT).show();
                        finish(); // 返回上一页
                    })
                    .setNegativeButton("取消", null)
                    .show();
        });
    }
}