package com.example.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ButtonActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);

        //按钮点击事件方式1：
        Button btn = (Button)findViewById(R.id.btn);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Log.d("czy", "click...");
//            }
//        });

        //按钮实现方式2： 当前类实现View.onClickListener, 并添加监听对象为this， 然后在onClick里面写点击事件
        btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.btn){
            Log.d("czy", "通过实现View.OnClickListener的方式实现点击事件");
            Toast.makeText(getApplicationContext(), "通过实现View.OnClickListener的方式实现点击事件", Toast.LENGTH_SHORT).show();
        }
    }
}
