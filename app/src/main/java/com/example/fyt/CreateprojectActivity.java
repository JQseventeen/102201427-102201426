package com.example.fyt;

import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.fyt.database.AppDatabase;
import com.example.fyt.database.Project;
import com.example.fyt.database.ProjectDao;

public class CreateprojectActivity extends AppCompatActivity {

    private EditText projectNameInput;
    private EditText projectMemberInput;
    private EditText projectDescriptionInput;
    private ImageView imageUpload;
    private static final int PICK_FILE_REQUEST_CODE = 100;
    private static final int PICK_IMAGE_REQUEST_CODE = 200;
    private Uri selectedFileUri;
    private Uri selectedImageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_project);

        projectNameInput = findViewById(R.id.projectNameInput);
        projectMemberInput = findViewById(R.id.projectMemberInput);
        projectDescriptionInput = findViewById(R.id.projectDescriptionInput);
        imageUpload = findViewById(R.id.imageUpload);
        Button confirmCreateButton = findViewById(R.id.confirmCreateButton);
        Button fileUploadButton = findViewById(R.id.fileUploadButton);

        // 返回按钮功能
        findViewById(R.id.backButton).setOnClickListener(v -> onBackPressed());

        // 文件上传按钮功能
        fileUploadButton.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
            intent.setType("*/*"); // 允许选择所有类型的文件
            startActivityForResult(intent, PICK_FILE_REQUEST_CODE);
        });

        // 图片上传功能
        imageUpload.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
            intent.setType("image/*"); // 只允许选择图片
            startActivityForResult(intent, PICK_IMAGE_REQUEST_CODE);
        });

        // 确认创建按钮功能
        confirmCreateButton.setOnClickListener(v -> {
            String projectName = projectNameInput.getText().toString();
            String projectMember = projectMemberInput.getText().toString();
            String projectDescription = projectDescriptionInput.getText().toString();

            // 处理选中的文件（如果有文件选择）
            if (selectedFileUri != null) {
                // 这里可以获取文件路径或进行其他操作
                String filePath = selectedFileUri.toString(); // 根据需要处理
            }

            // 处理选中的图片（如果有图片选择）
            if (selectedImageUri != null) {
                // 这里可以获取图片路径或进行其他操作
                String imagePath = selectedImageUri.toString(); // 根据需要处理
            }

            // 创建新项目并保存到数据库
            AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                    AppDatabase.class, "projects-database").build();
            ProjectDao projectDao = db.projectDao();

            Project newProject = new Project();
            newProject.name = projectName;
            newProject.members = projectMember;
            newProject.description = projectDescription;
            newProject.imagePath = selectedImageUri != null ? selectedImageUri.toString() : null;
            newProject.lastModified = System.currentTimeMillis();

            new Thread(() -> projectDao.insertProject(newProject)).start();

            // 创建新项目后跳转到项目详情页面
            Intent intent = new Intent(CreateprojectActivity.this, ProjectDetailActivity.class);
            intent.putExtra("projectName", projectName);
            intent.putExtra("projectMember", projectMember);
            intent.putExtra("projectDescription", projectDescription);
            if (selectedFileUri != null) {
                intent.putExtra("fileUri", selectedFileUri.toString()); // 传递文件URI
            }
            if (selectedImageUri != null) {
                intent.putExtra("imageUri", selectedImageUri.toString()); // 传递图片URI
            }
            startActivity(intent);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            if (requestCode == PICK_IMAGE_REQUEST_CODE) {
                // 处理图片选择结果
                selectedImageUri = data.getData();

                // 使用 Glide 将图片加载到 ImageView 中
                loadImageWithGlide(selectedImageUri);
            }
        }
    }

    private void loadImageWithGlide(Uri imageUri) {
        Glide.with(this)
                .load(imageUri)
                .into(imageUpload);
    }
}