package com.example.fyt;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.fyt.adapters.ProjectAdapter;
import com.example.fyt.database.AppDatabase;
import com.example.fyt.database.Project;
import com.example.fyt.database.ProjectDao;

import java.util.List;

public class StoreActivity extends AppCompatActivity {

    private Button buttonHome;
    private Button buttonChat;
    private Button buttonMain;
    private Button buttonWarehouse;
    private RecyclerView recyclerView;
    private ProjectAdapter projectAdapter;
    private ProjectDao projectDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_store);

        // 初始化组件
        buttonHome = findViewById(R.id.button_home);
        buttonChat = findViewById(R.id.button_chat);
        buttonMain = findViewById(R.id.button_main);
        buttonWarehouse = findViewById(R.id.button_warehouse);

        buttonMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("StoreActivity", "Home button clicked");
                Intent intent = new Intent(StoreActivity.this, TeamActivity.class);
                startActivity(intent);
            }
        });

        buttonChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到聊天
                Log.d("StoreActivity", "Home button clicked");
                Intent intent = new Intent(StoreActivity.this, ChatActivity1.class);
                startActivity(intent);
            }
        });

        buttonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 注意：如果buttonHome真的是指向“我的”页面，
                Intent intent = new Intent(StoreActivity.this, HomeActivity.class); // 或者 MyActivity.class
                startActivity(intent);
            }
        });

        buttonWarehouse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //仓库
                Intent intent = new Intent(StoreActivity.this, StoreActivity.class);
                startActivity(intent);
            }
        });


        LinearLayout createProjectLayout = findViewById(R.id.create_project);
        createProjectLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StoreActivity.this, CreateprojectActivity.class);
                startActivity(intent);
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.store), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "projects-database").build();
        projectDao = db.projectDao();

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        new Thread(() -> {
            List<Project> projects = projectDao.getAllProjects();
            runOnUiThread(() -> {
                projectAdapter = new ProjectAdapter(projects, this::openProjectDetails);
                recyclerView.setAdapter(projectAdapter);
            });
        }).start();

        // 读取 SharedPreferences 中的数据
        SharedPreferences sharedPreferences = getSharedPreferences("user_info", MODE_PRIVATE);
        String name = sharedPreferences.getString("name", "默认姓名");

        // 设置到 TextView 中
        TextView nameTextView = findViewById(R.id.user_name);

        nameTextView.setText(name + "的仓库" );

    }

    private void openProjectDetails(Project project) {
        Intent intent = new Intent(this, ProjectDetailActivity.class);
        intent.putExtra("projectName", project.name);
        intent.putExtra("projectMember", project.members);
        intent.putExtra("projectDescription", project.description);
        intent.putExtra("imageUri", project.imagePath);
        startActivity(intent);
    }

}