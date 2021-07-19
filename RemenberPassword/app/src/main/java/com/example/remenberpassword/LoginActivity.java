package com.example.remenberpassword;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onResume() {
        super.onResume();

        //判断是否记住密码 记住了密码直接去MainActivity
        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        if (preferences.getString("account", "").length() > 0){
//            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
//            startActivity(intent);

            final EditText account = (EditText)findViewById(R.id.account);
            final EditText password = (EditText)findViewById(R.id.password);
            account.setText(preferences.getString("account", ""));
            password.setText(preferences.getString("password", ""));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText account = (EditText)findViewById(R.id.account);
        final EditText password = (EditText)findViewById(R.id.password);
        final Button loginBrn = (Button)findViewById(R.id.loginBtn);
        final CheckBox remenberme = (CheckBox)findViewById(R.id.remenberme);

        loginBrn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String ac = account.getText().toString();
                String pwd = password.getText().toString();

                if ("czy".equals(ac) && "123456".equals(pwd)){

                    SharedPreferences preferences = getPreferences(MODE_PRIVATE);
                    SharedPreferences.Editor edit = preferences.edit();

                    //保存账户和密码
                    if (remenberme.isChecked()){

                        edit.putString("account", ac);
                        edit.putString("password", pwd);
                        edit.apply();
                    }else {

                        //清除账户和密码
                        edit.clear();
                        edit.apply();
                    }

                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
