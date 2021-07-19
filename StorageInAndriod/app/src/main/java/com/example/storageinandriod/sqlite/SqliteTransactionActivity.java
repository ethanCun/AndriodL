package com.example.storageinandriod.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.storageinandriod.R;

public class SqliteTransactionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_transaction);

        Button btn = (Button)this.findViewById(R.id.sqliteTransactionBtn);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                MyDatabaseHelper myDatabaseHelper = new MyDatabaseHelper(getApplicationContext(),
                        "user.db", null, 1);
                SQLiteDatabase db = myDatabaseHelper.getWritableDatabase();
                //开启书屋
                db.beginTransaction();

                int delete_lines = db.delete("t_user", "name=?", new String[]{"aaa"});
                Log.i("czy", "删除了 "+delete_lines+"行");

                try{

                    //手动抛出一个异常
                    int i =10/0;

                    //提交事务 执行到这里才真正成功
                    db.setTransactionSuccessful();
                }catch (Exception e){

                }finally {
                    db.endTransaction(); //结束事务
                }
            }
        });
    }
}
