package com.example.forcelogout;

import android.app.Activity;
import android.content.IntentFilter;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.forcelogout.receiver.ForceToLogoutReceiver;

//父类activity 用来接受通知
public class BaseActivity extends AppCompatActivity {

    private ForceToLogoutReceiver receiver ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityCollector.addActivity(this);
    }

    //重写onResume和onPause保证在栈顶的activity可以接收到通知
    @Override
    protected void onResume() {
        super.onResume();

        //捕获到接受强制下线的通知
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.ethan.forceToLogout");

        receiver = new ForceToLogoutReceiver();

        //通知绑定通知接受者
        registerReceiver(receiver, intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();

        //取消通知接受
        unregisterReceiver(receiver);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        ActivityCollector.removeActivity(this);
    }
}
