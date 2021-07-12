package com.example.activitylifecycletest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

//所有activity的父类
public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("czy", "当前activity名称: " + this.getClass().getSimpleName());
    }

    protected void jumpToNormalActivity(Context context, String name, String age){

        Intent intent = new Intent(context, NormalActivity.class);
        intent.putExtra("name", name);
        intent.putExtra("age", age);
        startActivity(intent);
    }
}
