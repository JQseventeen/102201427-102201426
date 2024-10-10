package com.example.fyt;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.content.SharedPreferences;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.makeramen.roundedimageview.RoundedImageView;

public class HomeActivity extends AppCompatActivity {

    private Button buttonHome;
    private Button buttonChat;
    private Button buttonMain;
    private Button buttonWarehouse;
    private ImageButton firstButton;
    private ImageButton secondButton;
    private ImageButton thirdButton;
    private ImageButton fourthButton;
    private ActivityResultLauncher<Intent> imagePickerLauncher;
    private RoundedImageView profileImage;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);

        // 初始化组件
        buttonHome = findViewById(R.id.button_home);
        buttonChat = findViewById(R.id.button_chat);
        buttonMain = findViewById(R.id.button_main);
        buttonWarehouse = findViewById(R.id.button_warehouse);

        firstButton = findViewById(R.id.first);
        secondButton = findViewById(R.id.second);
        thirdButton = findViewById(R.id.third);
        fourthButton = findViewById(R.id.fourth);


        profileImage = findViewById(R.id.profile_image);

        // 设置图片点击监听器
        profileImage.setOnClickListener(v -> {
            openImagePicker();
        });

        // 初始化图片选择器
        imagePickerLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                        Uri selectedImageUri = result.getData().getData();
                        // 将选择的图片加载到 RoundedImageView 中
                        profileImage.setImageURI(selectedImageUri);
                    }
                });

        // 设置点击监听器
        firstButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳到人才林编辑
                Intent intent = new Intent(HomeActivity.this, ForestDetailsActivity.class);
                startActivity(intent);
            }
        });
        secondButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳到设置帮助
                Intent intent = new Intent(HomeActivity.this, SettingsHelpActivity.class);
                startActivity(intent);
            }
        });
        thirdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳到聊天
                Intent intent = new Intent(HomeActivity.this, ChatActivity1.class);
                startActivity(intent);
            }
        });
        fourthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳到认证
                Intent intent = new Intent(HomeActivity.this, CertifyDetailsActivity.class);
                startActivity(intent);
            }
        });

        //底部导航栏
        buttonMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //首页
                Intent intent = new Intent(HomeActivity.this, TeamActivity.class);
                startActivity(intent);
            }
        });

        buttonChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到聊天
                Intent intent = new Intent(HomeActivity.this, ChatActivity1.class);
                startActivity(intent);
            }
        });

        buttonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 指向“我的”页面
                Intent intent = new Intent(HomeActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        buttonWarehouse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //仓库
                Intent intent = new Intent(HomeActivity.this, StoreActivity.class);
                startActivity(intent);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.home), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // 读取 SharedPreferences 中的数据
        SharedPreferences sharedPreferences = getSharedPreferences("user_info", MODE_PRIVATE);
        String name = sharedPreferences.getString("name", "默认姓名");
        String schoolNumber = sharedPreferences.getString("schoolNumber", "默认学号");

        // 设置到 TextView 中
        TextView nameTextView = findViewById(R.id.name);
        TextView schoolNumberTextView = findViewById(R.id.employee_id);

        nameTextView.setText("姓名: " + name);
        schoolNumberTextView.setText("学号: " + schoolNumber);


    }

    private void openImagePicker() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        imagePickerLauncher.launch(intent);
    }
}


