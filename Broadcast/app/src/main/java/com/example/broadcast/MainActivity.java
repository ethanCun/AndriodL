package com.example.broadcast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

//全局广播: 包含标准广播和有序广播 标准广播所有BroadcatReceiver都可以收到，有序广播会挨个挨个收到
public class MainActivity extends AppCompatActivity {

    private TimeChangeReceiver timeChangeReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //动态注册广播
        IntentFilter intentFilter = new IntentFilter();
        //系统时间改变的action
        intentFilter.addAction("android.intent.action.TIME_TICK");

        TimeChangeReceiver timeChangeReceiver = new TimeChangeReceiver();
        registerReceiver(timeChangeReceiver, intentFilter);

        final TextView tv1 = (TextView)findViewById(R.id.tv1);
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //发送广播  根据广播值构建Intent
                Intent intent = new Intent("com.example.broadcast.MY_BROADCAST");
                //指明广播的应用包名
                intent.setPackage(getPackageName());
                sendBroadcast(intent);
            }
        });

        final TextView tv2 = (TextView)findViewById(R.id.tv2);
        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //发送有序广播
                Intent intent = new Intent("com.example.broadcast.MY_ORDERED_BROADCAST");
                intent.setPackage(getPackageName());
                sendOrderedBroadcast(intent, null);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.timeChangeReceiver);
    }
}
