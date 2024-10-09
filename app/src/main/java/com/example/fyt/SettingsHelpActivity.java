package com.example.fyt;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SettingsHelpActivity extends AppCompatActivity {

    private EditText inputCommand;
    private LinearLayout chatLayout;
    private ScrollView chatScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_help);

        inputCommand = findViewById(R.id.input_command);
        ImageButton sendButton = findViewById(R.id.send_button);
        chatLayout = findViewById(R.id.chat_layout);
        chatScrollView = findViewById(R.id.chat_scroll_view);
        ImageButton backButton = findViewById(R.id.back_button);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleInputCommand();
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 启动HomeActivity
                Intent intent = new Intent(SettingsHelpActivity.this, HomeActivity.class);
                startActivity(intent);
                finish(); // 可选：结束当前活动，以防返回堆栈中有该活动
            }
        });
    }

    private void handleInputCommand() {
        String command = inputCommand.getText().toString().trim();
        if (command.isEmpty()) {
            return;
        }

        // 添加用户输入的气泡信息
        displayChatBubble(command, true);

        String response;
        switch (command) {
            case "1":
                response = "身份认证\n 进入我的 -> 身份认证 -> 认证，\n 即可增删您的身份认证信息";
                break;
            case "2":
                response = "人才林信息修改\n 进入我的 -> 编辑我的人才林，\n 即可增删您的人才标签信息";
                break;
            case "3":
                response = "项目管理\n 进入仓库 -> 创建项目，\n 即可新建或管理您的项目";
                break;
            default:
                response = "无效命令，请输入1, 2或3。";
        }

        // 添加系统响应的气泡信息
        displayChatBubble(response, false);
        inputCommand.setText(""); // 清空输入框

        // 滚动到最新信息
        chatScrollView.post(() -> chatScrollView.fullScroll(View.FOCUS_DOWN));
    }

    private void displayChatBubble(String message, boolean isUserMessage) {
        TextView textView = new TextView(this);
        textView.setText(message);
        textView.setTextSize(16);
        textView.setPadding(16, 8, 16, 8);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(8, 8, 8, 8);

        if (isUserMessage) {
            // 用户消息靠右显示
            params.gravity = Gravity.END;
            textView.setBackground(getResources().getDrawable(R.drawable.user_bubble_background));
        } else {
            // 系统消息靠左显示
            params.gravity = Gravity.START;
            textView.setBackground(getResources().getDrawable(R.drawable.system_bubble_background));
        }
        textView.setLayoutParams(params);
        chatLayout.addView(textView);
    }
}
/*import android.os.Bundle;
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
*/