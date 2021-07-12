package com.example.customui;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class TitleLayout extends LinearLayout {

    //context: 其实是一个Activity参数
    public TitleLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        //第一个参数： 加载的布局对象
        //第二个参数：给加载好的布局添加父布局
        LayoutInflater.from(context).inflate(R.layout.title, this);

        //将自定义的公共组件事件全部写到自定义layout中
        Button btn1 = (Button)findViewById(R.id.titleBack);
        Button btn2 = (Button)findViewById(R.id.naviRight);
        final TextView tv = (TextView)findViewById(R.id.titleTextView);

        btn1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                Log.i("czy", "点击了返回按钮");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Log.i("czy", "点击了编辑按钮");
            }
        });

//        tv.setClickable(true);
        tv.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.i("czy", tv.getText().toString());
            }
        });

    }


}
