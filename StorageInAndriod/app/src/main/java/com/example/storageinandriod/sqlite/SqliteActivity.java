package com.example.storageinandriod.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.storageinandriod.R;
import com.example.storageinandriod.sqlite.MyDatabaseHelper;

import javax.xml.transform.Source;

//安卓内置了Sqlite数据库
public class SqliteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);

        //建库的时候会调用自定义的SqlDatabaseHelper的onCreate方法 在这个方法里面可以建表
        Button createBtn = (Button)findViewById(R.id.createSqlBtn);
        createBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                MyDatabaseHelper myDatabaseHelper = new MyDatabaseHelper(getApplicationContext(),
                        "user2.db",
                        null,
                        1);

                //获取可写入的数据库， 这个时候会调用onCreate方法
                SQLiteDatabase writableDatabase = myDatabaseHelper.getWritableDatabase();
                Log.i("czy", String.valueOf(writableDatabase));
            }
        });

        final EditText nameET = (EditText)this.findViewById(R.id.nameET);
        final EditText ageET = (EditText)this.findViewById(R.id.ageET);
        Button insertDataBtn = (Button)this.findViewById(R.id.insertDataBtn);
        Button deleteDataBtn = (Button)this.findViewById(R.id.deleteDataBtn);
        Button updateDataBtn = (Button)this.findViewById(R.id.updateDataBtn);
        Button searchDataBtn = (Button)this.findViewById(R.id.searchDataBtn);
        Button sqlOperateBtn = (Button)this.findViewById(R.id.sqlOperateBtn);

        //获取数据库对象
        MyDatabaseHelper myDatabaseHelper = new MyDatabaseHelper(getApplicationContext(),
                "user.db",
                null,
                1);

        final SQLiteDatabase writableDatabase = myDatabaseHelper.getWritableDatabase();

        //插入数据
        insertDataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //第一个参数：表名
                //第二个参数：null
                //第三个参数： 用于填充数据
                ContentValues contentValues = new ContentValues();
                contentValues.put("name", nameET.getText().toString());
                contentValues.put("age", ageET.getText().toString());
                long insertRes = writableDatabase.insert("t_user", null, contentValues);
                if (insertRes != -1){
                    Toast.makeText(getApplicationContext(), "添加数据成功", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getApplicationContext(), "添加数据失败", Toast.LENGTH_SHORT).show();
                }

            }
        });

        //删除数据
        deleteDataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int delete_lines = writableDatabase.delete("t_user", "name=?", new String[]{"zhangsan"});
                Log.i("czy", "删除了 " + delete_lines + " 行");
            }
        });

        //修改数据
        updateDataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ContentValues contentValues = new ContentValues();
                contentValues.put("age", "1000");
                //返回受影响的行数
                int update_lines = writableDatabase.update("t_user", contentValues, "name=?", new String[]{"zhangsan"});
                Log.i("czy", "update_lines = " + update_lines);
            }
        });

        //查找数据
        searchDataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //第一个参数： 表名
                //第二个参数： 查找指定列
                //第三四个参数： 约束条件
                //第五个参数：分组
                //第六个：筛选
                //第七个：排序
                Cursor userCursor = writableDatabase.query("t_user",
                        null,
                        null,
                        null,
                        null,
                        null,
                        null);

                if (userCursor.moveToFirst()){

                    //循环移动到下一行
                    do{

                        Integer id = userCursor.getInt(userCursor.getColumnIndex("id"));
                        String name = userCursor.getString(userCursor.getColumnIndex("name"));
                        String age = userCursor.getString(userCursor.getColumnIndex("age"));

                        Log.i("czy", "id =" + id + " name = " + name + " age = " + age);

                    }while (userCursor.moveToNext());

                }else {
                    Log.i("czy", "表中无数据");
                }

                //关闭
                userCursor.close();
            }
        });

        //使用sql操作数据库
        sqlOperateBtn.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

//                Object[] params = new Object[2];
//                params[0] = nameET.getText().toString();
//                params[1] = ageET.getText().toString();
//
//                try {
//                    writableDatabase.execSQL("insert into t_user (name, age) values (?, ?)",
//                            params);
//                    Log.i("czy", "数据插入成功");
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }


                Cursor cursor = writableDatabase.rawQuery("select count(*) from t_user", null);
                cursor.moveToFirst(); //移动到首行
                long count = cursor.getLong(0);
                Log.i("czy", "数量： " + count);

            }
        });
    }

}
