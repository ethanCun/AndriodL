package com.example.storageinandriod;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//演示将数据保存到安卓文件 然后从文件中读取
//数据保存在/data/data/包名/files下面， 可以使用DeviceFileExplorer查看
public class FileSaveActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_save);

        final EditText editText = (EditText)this.findViewById(R.id.inputT);
        Button fileSaveBtn = (Button)this.findViewById(R.id.fileSaveBtn);
        Button readFileBtn = (Button)this.findViewById(R.id.readFileBtn);

        //保存数据
        fileSaveBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                saveData(editText.getText().toString());
            }
        });

        //读取数据
        readFileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), readData(), Toast.LENGTH_SHORT).show();
                Log.i("czy", "读取到数据:" + readData());
            }
        });

    }

    //使用文件保存数据
    private void saveData(String content){

        //第一个参数：文件名
        //第二个参数: 文件的操作模式 mode_private mode_append 分别为覆盖模式和追加模式
        FileOutputStream fileOutputStream = null;

        try {
            fileOutputStream = openFileOutput("data", Context.MODE_PRIVATE);
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
            try {
                bufferedWriter.write(content);
                Log.i("czy", "保存成功");
            } catch (IOException e) {
                e.printStackTrace();
                Log.i("czy", "保存失败");
            }finally {

                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    //读取数据
    private String readData(){


        //主需要文件名称， 自动拼接成文件保存路径
        try {
            FileInputStream data = openFileInput("data");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(data));

            StringBuffer sb = new StringBuffer();
            String s = "";
            while ((s = bufferedReader.readLine()) != null){
                sb.append(s);
            }

            bufferedReader.close();

            return sb.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return "";
    }
}
