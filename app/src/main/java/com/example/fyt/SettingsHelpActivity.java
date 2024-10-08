package com.example.fyt;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class SettingsHelpActivity extends AppCompatActivity {

    private EditText inputCommand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_help);

        // 初始化视图
        inputCommand = findViewById(R.id.input_command);
        ImageButton backButton = findViewById(R.id.back_button);
        ImageButton sendButton = findViewById(R.id.send_button);

        // 返回按钮点击事件
        backButton.setOnClickListener(view -> finish());

        // 发送按钮点击事件
        sendButton.setOnClickListener(view -> {
            String command = inputCommand.getText().toString();
            sendCommand(command);
        });
    }

    private void sendCommand(String command) {
        if (command.isEmpty()) {
            Toast.makeText(this, "请输入指令", Toast.LENGTH_SHORT).show();
        } else {
            // 在此处插入处理命令的逻辑
            Toast.makeText(this, "您输入的指令是: " + command, Toast.LENGTH_SHORT).show();
        }
    }
}