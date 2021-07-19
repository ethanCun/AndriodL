package com.example.forcelogout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //添加activity
        //ActivityCollector.addActivity(this);

        //登录逻辑
        final EditText accountET = (EditText)this.findViewById(R.id.accountEt);
        final EditText passwordEt = (EditText)this.findViewById(R.id.passwordEt);
        Button loginBtn = (Button)this.findViewById(R.id.loginBtn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if ("czy".equals(accountET.getText().toString()) && "123456".equals(passwordEt.getText().toString())){

                    //登录成功
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }else {

                    Toast.makeText(getApplicationContext(), "账号或密码错误", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        ActivityCollector.removeActivity(this);
    }
}
