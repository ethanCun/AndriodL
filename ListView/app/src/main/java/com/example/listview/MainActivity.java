package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.listview.adapter.FruitAdapter;
import com.example.listview.entity.Fruit;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String[] data = new String[]{"apple", "banana", "orange", "pear","apple", "banana", "orange", "pear",
            "apple", "banana", "orange", "pear","apple", "banana", "orange", "pear","apple", "banana", "orange", "pear"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //隐藏自带的盗号了
//        getSupportActionBar().hide();

        ListView listView = (ListView)findViewById(R.id.listview1);

        //借助适配器来给listView赋值
        //第一个参数： Context: 当前activity
        //第二个参数: Resource id (android.R.layout.simple_list_item_1 是安卓内置的布局文件， 只有一个textView)
        //第三个参数： 数据
//        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);
//        listView.setAdapter(stringArrayAdapter);

        //自定义适配器
        FruitAdapter fruitAdapter = new FruitAdapter(this, R.layout.fruit_item, getData());
        listView.setAdapter(fruitAdapter);

        //ListView点击事件
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast toast = Toast.makeText(getApplicationContext(), getData().get(position).getName(), Toast.LENGTH_LONG);
                toast.show();
            }
        });
    }

    private List<Fruit> getData(){

       List<Fruit> fruits = new ArrayList<Fruit>();
        for (int i = 0; i < 20; i++) {
            Fruit fruit = new Fruit();
            fruit.setName("fruitfruitfruitfruitfruitfruitfruitfruitfruitfruitfruitfruitfruitfruitfruit" + i+1);
            fruit.setImg("");

            fruits.add(fruit);
        }

        return fruits;
    }
}
