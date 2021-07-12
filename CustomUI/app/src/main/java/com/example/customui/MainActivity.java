package com.example.customui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        隐藏自带的导航栏
        getSupportActionBar().hide();

//        Button backBnt = (Button)findViewById(R.id.titleBack);
//        backBnt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Log.i("czy", "click...");
//                finish();
//
//            }
//        });
    }
}
