package com.example.storageinandriod.sharedPreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.storageinandriod.R;
import com.example.storageinandriod.entity.Czy;

//演示安卓将数据保存到SharedPreferences
//SharePreferences 是将数据以键值对的形式保存在
//保存在/data/data/包名/shared_prefs下面， 以xml的形式保存
public class SharedPreferencesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);

        final EditText name = (EditText)this.findViewById(R.id.inputName);
        final EditText age = (EditText)this.findViewById(R.id.inputAge);
        Button saveBtn = (Button)this.findViewById(R.id.sharedPreferencesSaveDataBtn);
        Button readBtn = (Button)this.findViewById(R.id.sharedPreferencesReadDataBtn);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                saveData(name.getText().toString(), age.getText().toString());
            }
        });

        readBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                readData();
            }
        });
    }

    //使用SharedPreferences保存数据
    private void saveData(String name, String age){

        //获取SharedPreferences对象
        //方式1：
        //第一个参数指定SharedPreferences文件的名称， 如果不存在会创建一个， 数据会保存在/data/data/包名/shared_prefs下面
        //第二个参数指定操作模式
        //SharedPreferences sharedPreferences = getSharedPreferences("czy", MODE_PRIVATE);


        //方式2：
        //自动将SharedPreferences名称指定为当前类名
        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);

        //存储数据3部曲：
        SharedPreferences.Editor edit = sharedPreferences.edit();

        //添加数据
        edit.putString("name", name);
        edit.putString("age", age);

        //提交数据
        edit.apply();
    }

    //读取数据
    private void readData(){

        //获取SharedPreferences对象
        SharedPreferences preferences = getPreferences(MODE_PRIVATE);

        //读取数据不用Editor对象
        String name = preferences.getString("name", "");
        String age = preferences.getString("age", "");

        Toast.makeText(getApplicationContext(), "姓名："+name+" 年龄:"+age, Toast.LENGTH_SHORT).show();
    }
}
