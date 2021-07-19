package com.example.storageinandriod.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

//Sqlite需要重写抽象类的像个方法 onCreate和onUpgrade方法
public class MyDatabaseHelper extends SQLiteOpenHelper {

    private Context context;
    private String dbname;
    SQLiteDatabase.CursorFactory factory;
    int version;

    //创建数据库的sql
    private String sql_create_user = "create table if not exists t_user (id integer primary key autoincrement, name text, age integer)";
    //创建角色表
    private String sql_create_role = "create table if not exists t_role (id integer primary key autoincrement, name text)";
    //创建权限表
    private String sql_create_perm = "create table if not exists t_perm (id integer primary key autoincrement, name text)";

    //需要重写构造方法
    //参数1： 上下文
    //参数2： 数据库名
    //参数3:  允许在查询数据库时返回一个自定义的cursor
    //参数4： 当前数据库的版本号
    public MyDatabaseHelper(@Nullable Context context,
                            @Nullable String name,
                            @Nullable SQLiteDatabase.CursorFactory factory,
                            int version) {

        super(context, name, factory, version);

        this.context = context;
        this.dbname = name;
        this.factory = factory;
        this.version = version;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //执行建表操作
        Log.i("czy", "开始创表");
        db.execSQL(sql_create_user);
        db.execSQL(sql_create_role);
        Toast.makeText(this.context, "表创建成功", Toast.LENGTH_SHORT).show();
        Log.i("czy", "创表成功");
    }

    //用于数据库升级的方法
    @Override
    public void onUpgrade(SQLiteDatabase db,
                          int oldVersion,
                          int newVersion) {

        Log.i("czy", "数据库升级");
//        db.execSQL("drop table if exists t_user");
//        db.execSQL("drop table if exists t_role");
//        onCreate(db);

        if (oldVersion <= 1){
            db.execSQL(sql_create_perm);
        }
    }

}
