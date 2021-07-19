package com.example.collectioncyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import com.example.collectioncyclerview.adapter.FruitAdapter;
import com.example.collectioncyclerview.entity.Fruit;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //产生不同长度的名字
    private String generateName(String s){

        int i = new Random().nextInt(5);

        StringBuilder sb = new StringBuilder();
        for (int i1 = 0; i1 < i; i1++) {
            sb.append(s + " ");
        }

        return sb.toString();
    }

    private List<Fruit> getFruits(){

        List<Fruit> fruits = new ArrayList<>();

        for (int i = 0; i < 200; i++) {

            String name = this.generateName("fruit" + i+1);

            Fruit fruit = new Fruit();
            fruit.setImg("");
            fruit.setName(name);
            fruits.add(fruit);
        }

        return fruits;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //瀑布流布局
        //第一个参数： 指定列数
        //第二个参数: 指定布局的排列方向
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL);

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(layoutManager);

        FruitAdapter fruitAdapter = new FruitAdapter(getFruits());
        recyclerView.setAdapter(fruitAdapter);
    }
}
