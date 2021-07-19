package com.example.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;


public class MyBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context, "received in MyBroadcastReceiver ...", Toast.LENGTH_SHORT).show();

        //有序广播的广播消息可以被截断
        //abortBroadcast();
    }
}
