package com.example.fyt;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.content.SharedPreferences;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CertifyActivity extends AppCompatActivity {

    private EditText nameInput, schoolInput, schoolnumberInput;

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_certify);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.certify_page), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // 初始化 SharedPreferences
        sharedPreferences = getSharedPreferences("user_info", MODE_PRIVATE);
        editor = sharedPreferences.edit();


        nameInput = findViewById(R.id.editTextDate2);
        schoolnumberInput= findViewById(R.id.editTextNumber);
        schoolInput= findViewById(R.id.editTextDate);
        Button facebutton = findViewById(R.id.certify_button);
        facebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 获取选中的身份
                Spinner spinner = findViewById(R.id.spinner);
                String selectedIdentity = spinner.getSelectedItem().toString();

                // 假设我们还有其他信息，如姓名和学校
                String name = nameInput.getText().toString();// 这里你可以获取实际的用户输入
                String school = schoolInput.getText().toString();
                String schoolNumber = schoolnumberInput.getText().toString();

                // 保存身份信息到 SharedPreferences
                editor.putString("identity", selectedIdentity);
                editor.putString("name", name);
                editor.putString("school", school);
                editor.putString("schoolNumber", schoolNumber);
                editor.apply();

                // 跳转到身份信息显示页面
                Intent intent = new Intent(CertifyActivity.this, CertifyDetailsActivity.class);
                startActivity(intent);
            }
        });

        ImageButton backbutton = findViewById(R.id.certify_back_button);
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 跳转到HomeActivity
                Intent intent = new Intent(CertifyActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        Spinner spinner = findViewById(R.id.spinner);
        String[] options = {"教师", "学生", "助教"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, options);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }
}