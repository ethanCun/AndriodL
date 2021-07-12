package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //设置layout
        setContentView(R.layout.activity_main3);

        //找到按钮
        Button btn = (Button) findViewById(R.id.btn1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("czy", "click");

                Toast.makeText(getApplicationContext(), "toast show", Toast.LENGTH_LONG).show();
            }
        });
    }

    //创建可选菜单的回调方法
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        //关联menu  menu资源文件id menu对象
        getMenuInflater().inflate(R.menu.main, menu);

        return true;
    }

    //menu菜单点击时间

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

//        Log.d("czy", String.valueOf(item.getItemId()));
//        Log.d("czy", String.valueOf(item.getTitle()));

        if (item.getItemId() == R.id.add_item){
            Toast.makeText(getApplicationContext(), "click add", Toast.LENGTH_SHORT).show();
        }else if (item.getItemId() == R.id.remove_item){
//            Toast.makeText(getApplicationContext(), "click remove", Toast.LENGTH_LONG).show();

            //销毁当前activity
            finish();
        }else if (item.getItemId() == R.id.mainActivity4){

            //intent页面跳转
            Intent intent = new Intent(getApplicationContext(), Main4Activity.class);
            startActivity(intent);
        }else if (item.getItemId() == R.id.inshiTomainActivity4){

            //intent隐式跳转(根据AndriodManifest.xml中的andriod:name进行跳转)
            Intent intent = new Intent("com.example.myapplication.Main4Activity.ACTION_START");
            //隐式的category就是DEFAUL， 因此可以不写
            intent.addCategory("android.intent.category.DEFAULT2");
            startActivity(intent);
        }else if (item.getItemId() == R.id.web){

            //打开自带的浏览器
//            Intent webIntent = new Intent(Intent.ACTION_VIEW);
//            webIntent.setData(Uri.parse("https://www.baidu.com"));
//            startActivity(webIntent);

            //拨打电话
            Intent telIntent = new Intent(Intent.ACTION_DIAL);
            telIntent.setData(Uri.parse("tel:10086"));
            startActivity(telIntent);

        }else if (item.getItemId() == R.id.activity5){

            //跳转到按此activity5
            Intent activity5 = new Intent(getApplicationContext(), Main5Activity.class);
            activity5.setData(Uri.parse("https://www.baidu.com"));
            startActivity(activity5);
        }else if (item.getItemId() == R.id.activity6){

            //向下个界面传递数据
            Intent act6 = new Intent(getApplicationContext(), Main6Activity.class);

            //传递数据
            act6.putExtra("name", "czy");
            act6.putExtra("age", 29);

//            startActivity(act6);
            //调用做个方法跳转到下个界面， 下个界面销毁后会走onActivityResult方法
            startActivityForResult(act6, 1);
        }else if (item.getItemId() == R.id.activity7){

            //activity生命周期
            Intent intent = new Intent(getApplicationContext(), Main7Activity.class);
            startActivity(intent);
        }



        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        //requestCode 是startActivityForResult 传入的
        Log.d("czy", "requestCode = " + requestCode);
        //resultCode 是下一个界面 setResult 传入的
        Log.d("czy", "resultCode = " + resultCode);

        if (resultCode == RESULT_OK){
            Log.d("czy", "下个界面向上个界面传值：" + data.getStringExtra("sex"));
        }
    }
}
