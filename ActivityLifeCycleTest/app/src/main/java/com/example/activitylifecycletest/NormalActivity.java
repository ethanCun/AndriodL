package com.example.activitylifecycletest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class NormalActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);

        Log.d("czy", this.toString() + "onCreate" + " task id is " + getTaskId());

        String name = getIntent().getStringExtra("name");
        String age = getIntent().getStringExtra("age");
        Log.d("czy", "name: " + name + " age: " + age);

        Button btn =  findViewById(R.id.thirdActivity);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), ThirdActivity.class);
                startActivity(intent);
            }
        });
    }

//    @Override
//    public void onBackPressed() {
//
//        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//        startActivity(intent);
//    }
}
