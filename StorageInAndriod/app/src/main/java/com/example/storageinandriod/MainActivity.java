package com.example.storageinandriod;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.storageinandriod.file.FileSaveActivity;
import com.example.storageinandriod.sharedPreferences.SharedPreferencesActivity;
import com.example.storageinandriod.sqlite.SqliteActivity;
import com.example.storageinandriod.sqlite.SqliteTransactionActivity;

//测试Android通过文件保存数据， 通过DeviceFileExplorer查询数据保存位置
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button fileSave = (Button)this.findViewById(R.id.file);
        Button sharedPreferences = (Button)this.findViewById(R.id.sharedPreferences);
        Button sqlite = (Button)this.findViewById(R.id.sqlite);
        final Button sqliteTransaction = (Button)this.findViewById(R.id.sqliteTransactionGo);

        fileSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FileSaveActivity.class);
                startActivity(intent);
            }
        });

        sharedPreferences.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), SharedPreferencesActivity.class);
                startActivity(intent);
            }
        });

        sqlite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), SqliteActivity.class);
                startActivity(intent);
            }
        });

        sqliteTransaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), SqliteTransactionActivity.class);
                startActivity(intent);
            }
        });

    }

}
