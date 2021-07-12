package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

//界面3向界面6传递数据
public class Main6Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        //获取从界面3传过来的数据
        String name = getIntent().getStringExtra("name");
        Integer age = getIntent().getIntExtra("age", 0);

        Log.d("czy", "正向传值name: "+name);
        Log.d("czy", "正向传值age: "+age);

        //向上个界面传递数据
        Button btn6 = (Button) findViewById(R.id.btn6);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //仅仅用户传递数据的intent
                Intent intent = new Intent();
                intent.putExtra("sex", "man");
                setResult(RESULT_OK, intent); //绑定intent和处理结果
                finish();//销毁当前activity
            }
        });
    }

    //用户点击back按钮的回调
    @Override
    public void onBackPressed() {
        Log.d("czy", "用户点击了返回按钮");

        Intent intent = new Intent();
        intent.putExtra("sex", "women");
        setResult(RESULT_OK, intent);
        finish();
    }
}
