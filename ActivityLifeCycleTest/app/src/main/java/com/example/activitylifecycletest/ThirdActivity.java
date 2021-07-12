package com.example.activitylifecycletest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class ThirdActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Log.d("czy", "third activity onCreate task id is " + getTaskId());
    }


//    @Override
//    public void onBackPressed() {
//
//        android.os.Process.killProcess(android.os.Process.myUid());
//    }
}
