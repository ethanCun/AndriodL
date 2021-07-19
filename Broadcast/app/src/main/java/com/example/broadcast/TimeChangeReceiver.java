package com.example.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

//动态注册广播
public class TimeChangeReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Log.i("czy", "timeChanged" + intent.getAction());
//        Toast.makeText(context, "time has changed", Toast.LENGTH_LONG).show();
    }
}
