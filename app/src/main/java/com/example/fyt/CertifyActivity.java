package com.example.fyt;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CertifyActivity extends AppCompatActivity {

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

        Button facebutton =findViewById(R.id.certify_button);
        // 设置点击监听器
        facebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳到word
                Intent intent = new Intent(CertifyActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
        ImageButton backbutton =findViewById(R.id.certify_back_button);
        // 设置点击监听器
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳到word
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