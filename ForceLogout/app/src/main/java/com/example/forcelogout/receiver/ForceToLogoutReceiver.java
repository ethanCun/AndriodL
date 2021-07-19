package com.example.forcelogout.receiver;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

import com.example.forcelogout.ActivityCollector;
import com.example.forcelogout.LoginActivity;

//自定义通知接受者
public class ForceToLogoutReceiver extends BroadcastReceiver {

    //接受到通知的处理逻辑
    @Override
    public void onReceive(final Context context, Intent intent) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("提示");
        builder.setMessage("您将被强制下线");
        builder.setCancelable(false);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                ActivityCollector.finishAll();

                Intent loginIntent = new Intent(context, LoginActivity.class);
                context.startActivity(loginIntent);
            }
        });

        builder.show();
    }
}
