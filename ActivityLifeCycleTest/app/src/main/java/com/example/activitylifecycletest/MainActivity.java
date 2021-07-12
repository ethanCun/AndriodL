package com.example.activitylifecycletest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Log.d("czy", "bundle用来获取上次在onSaveInstance里面保存的数据");
//        String content = savedInstanceState.getString("content");
//        Log.d("czy", "content = " + content);

        Log.d("czy", this.toString() + "onCreate" + " task id is " + getTaskId());

        Button btn1 = (Button)findViewById(R.id.startNormalActivity);
        Button btn2 = (Button)findViewById(R.id.startDialogActivity);
        Button btn3 = (Button)findViewById(R.id.mainActivity2);
        Button btn4 = (Button)findViewById(R.id.thirdActivity);
        Button btn5 = (Button)findViewById(R.id.startFourthActivity);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), NormalActivity.class);
                startActivity(intent);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DialogActivity.class);
                startActivity(intent);
            }
        });

        //mainActivity中启动mainActivity
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent4 = new Intent(getApplicationContext(), FourthActivity.class);
                startActivity(intent4);
            }
        });
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("czy", "main onDestroy");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("czy", "main onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("czy", "main onStop");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("czy", "main onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("czy", "main onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("czy", "onRestart");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        Log.d("czy","onSaveInstanceSate activity即将被回收的时候调用");
        outState.putString("content", "即将销毁的时候保存数据");
    }
}
