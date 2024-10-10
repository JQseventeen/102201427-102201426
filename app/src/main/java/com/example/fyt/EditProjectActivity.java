package com.example.fyt;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.room.Room;

import com.example.fyt.database.AppDatabase;
import com.example.fyt.database.Project;
import com.example.fyt.database.ProjectDao;

public class EditProjectActivity extends AppCompatActivity {

    private EditText editProjectNameInput;
    private EditText editProjectMemberInput;
    private EditText editProjectDescriptionInput;
    private ImageView editImageUpload;
    private Button editConfirmButton;
    private Button deleteProjectButton;
    private static final int PICK_IMAGE_REQUEST_CODE = 200;

    private Uri selectedImageUri;
    private long projectId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_project);

        editProjectNameInput = findViewById(R.id.editProjectNameInput);
        editProjectMemberInput = findViewById(R.id.editProjectMemberInput);
        editProjectDescriptionInput = findViewById(R.id.editProjectDescriptionInput);
        editImageUpload = findViewById(R.id.editImageUpload);
        editConfirmButton = findViewById(R.id.editConfirmButton);
        deleteProjectButton = findViewById(R.id.deleteProjectButton);

        // 获取传递过来的项目数据
        Intent intent = getIntent();
        projectId = intent.getLongExtra("projectId", -1);
        String projectName = intent.getStringExtra("projectName");
        String projectMember = intent.getStringExtra("projectMember");
        String projectDescription = intent.getStringExtra("projectDescription");
        String imageUri = intent.getStringExtra("imageUri");

        // 填充现有数据
        editProjectNameInput.setText(projectName);
        editProjectMemberInput.setText(projectMember);
        editProjectDescriptionInput.setText(projectDescription);
        if (imageUri != null) {
            selectedImageUri = Uri.parse(imageUri);
            editImageUpload.setImageURI(selectedImageUri);
        }

        // 设置保存修改按钮的功能
        editConfirmButton.setOnClickListener(v -> {
            String updatedName = editProjectNameInput.getText().toString();
            String updatedMember = editProjectMemberInput.getText().toString();
            String updatedDescription = editProjectDescriptionInput.getText().toString();

            // 更新项目
            new Thread(() -> {
                AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                        AppDatabase.class, "projects-database").build();
                ProjectDao projectDao = db.projectDao();

                    runOnUiThread(() -> {
                        Toast.makeText(EditProjectActivity.this, "项目已更新", Toast.LENGTH_SHORT).show();
                        Intent intent1 = new Intent(EditProjectActivity.this, ProjectDetailActivity.class);
                        intent1.putExtra("projectId", projectId);  // 传递项目 ID
                        startActivity(intent1);
                        finish();
                    });
            }).start();
        });



        deleteProjectButton.setOnClickListener(view -> {
            // 执行删除项目的逻辑
            new AlertDialog.Builder(EditProjectActivity.this)
                    .setTitle("删除项目")
                    .setMessage("确定要删除此项目吗？")
                    .setPositiveButton("删除", (dialog, which) -> {
                        // 执行删除操作，这里可以添加删除逻辑
                        Toast.makeText(EditProjectActivity.this, "项目已删除", Toast.LENGTH_SHORT).show();
                        Intent intent2 = new Intent(EditProjectActivity.this, StoreActivity.class);
                        startActivity(intent2);
                        finish(); // 返回上一页
                    })
                    .setNegativeButton("取消", null)
                    .show();
        });

/*
        // 设置保存修改按钮的功能
        editConfirmButton.setOnClickListener(v -> {
            String updatedName = editProjectNameInput.getText().toString();
            String updatedMember = editProjectMemberInput.getText().toString();
            String updatedDescription = editProjectDescriptionInput.getText().toString();

            // 更新项目
            new Thread(() -> {
                AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                        AppDatabase.class, "projects-database").build();
                ProjectDao projectDao = db.projectDao();
                Project project = projectDao.findById(projectId);
                if (project != null) {
                    project.name = updatedName;
                    project.members = updatedMember;
                    project.description = updatedDescription;
                    project.imagePath = selectedImageUri != null ? selectedImageUri.toString() : null;
                    project.lastModified = System.currentTimeMillis();
                    projectDao.updateProject(project);

                    runOnUiThread(() -> {
                        Toast.makeText(EditProjectActivity.this, "项目已更新", Toast.LENGTH_SHORT).show();
                        Intent intent1 = new Intent(EditProjectActivity.this, ProjectDetailActivity.class);
                        intent1.putExtra("projectId", projectId);  // 传递项目 ID
                        startActivity(intent1);
                        finish();
                    });
                }
            }).start();
        });
*/
  /*      // 设置删除项目按钮的功能
        deleteProjectButton.setOnClickListener(v -> {
            new AlertDialog.Builder(EditProjectActivity.this)
                    .setTitle("删除项目")
                    .setMessage("确定要删除此项目吗？")
                    .setPositiveButton("删除", (dialog, which) -> {
                        new Thread(() -> {
                            AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                                    AppDatabase.class, "projects-database").build();
                            ProjectDao projectDao = db.projectDao();
                            Project project = projectDao.findById(projectId);
                            if (project != null) {
                                projectDao.deleteProject(project);

                                runOnUiThread(() -> {
                                    Toast.makeText(EditProjectActivity.this, "项目已删除", Toast.LENGTH_SHORT).show();
                                    Intent intent2 = new Intent(EditProjectActivity.this, StoreActivity.class);
                                    startActivity(intent2);
                                    finish();
                                });
                            }
                        }).start();
                    })
                    .setNegativeButton("取消", null)
                    .show();
        });

*/

        // 图片上传
        editImageUpload.setOnClickListener(v -> {
            Intent pickPhoto = new Intent(Intent.ACTION_GET_CONTENT);
            pickPhoto.setType("image/*");
            startActivityForResult(pickPhoto, PICK_IMAGE_REQUEST_CODE);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && data != null) {
            if (requestCode == PICK_IMAGE_REQUEST_CODE) {
                selectedImageUri = data.getData();
                editImageUpload.setImageURI(selectedImageUri);
            }
        }
    }
}