package com.example.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ImageViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);

        Button btn = (Button)findViewById(R.id.changeImagebtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ImageView imageView = (ImageView)findViewById(R.id.imgeV);

                //这里要注意判断图片是否为某一图片的方法是使用 constantState
                if (imageView.getDrawable().getCurrent().getConstantState()
                        == getResources().getDrawable(R.drawable.img_1).getConstantState()){
                    imageView.setImageResource(R.drawable.img_2);
                }else {
                    imageView.setImageResource(R.drawable.img_1);
                }
            }
        });
    }
}
