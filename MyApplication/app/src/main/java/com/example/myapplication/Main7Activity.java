package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

//演示activity生命周期的实例
public class Main7Activity extends AppCompatActivity {

    //在activity第一次被创建的时候调用
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);

        Log.d("czy", "onCreate...在activity第一次被创建的时候调用");
    }

    //在activity由不可见变为可见的时候调用
    @Override
    protected void onStart() {
        super.onStart();

        Log.d("czy", "onstart...在activity由不可见变为可见的时候调用");
    }

    //在activity准备好和用户交互的时候调用
    @Override
    protected void onResume() {
        super.onResume();

        Log.d("czy", "onresume..在activity准备好和用户交互的时候调用.");
    }

    //系统准备去启用另外一个activity的时候调用
    @Override
    protected void onPause() {
        super.onPause();

        Log.d("czy", "onPause...系统准备去启用另外一个activity的时候调用");
    }

    //在activity完全不见的时候调用
    @Override
    protected void onStop() {
        super.onStop();

        Log.d("czy", "onStop...在activity完全不见的时候调用");
    }

    //在被销毁前调用，之后状态变为已销毁
    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d("czy", "onDestroy...在被销毁前调用，之后状态变为已销毁");
    }

    //由停止状态变为运行状态之前调用
    @Override
    protected void onRestart() {
        super.onRestart();

        Log.d("czy", "onRestart.../由停止状态变为运行状态之前调用");
    }

}
