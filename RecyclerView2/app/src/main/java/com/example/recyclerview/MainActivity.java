package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.recyclerview.adapter.FruitAdapter;
import com.example.recyclerview.entity.Fruit;

import java.util.ArrayList;
import java.util.List;


//这个项目演示RecyclerView横向滚动
public class MainActivity extends AppCompatActivity {

    private List<Fruit> getData(){
        ArrayList<Fruit> fruits = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Fruit fruit = new Fruit();
            fruit.setImg("");
            fruit.setName("fruit "+(i+1));
            fruits.add(fruit);
        }
        return fruits;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //RecycleView的布局交给LayoutManager去管理， 因此它可以设置滚动方向
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getApplicationContext());

        //设置滚动方向为横向滚动
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recyclerView1);
        recyclerView.setLayoutManager(linearLayoutManager);

        FruitAdapter fruitAdapter = new FruitAdapter(getData());
        recyclerView.setAdapter(fruitAdapter);
    }


}
