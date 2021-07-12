package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.recyclerview.adapter.FruitAdapter;
import com.example.recyclerview.entity.Fruit;

import java.util.ArrayList;
import java.util.List;


//RecyclerView ： List的优化版， 解决ListView不能横向滚动的问题
public class MainActivity extends AppCompatActivity {

    private List<Fruit> getData(){

        ArrayList<Fruit> fruits = new ArrayList<>();

        for (int i = 0; i < 100; i++) {

            Fruit fruit = new Fruit();
            fruit.setImg("");
            fruit.setName("fruit" + (i+1));

            fruits.add(fruit);
        }

        return fruits;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recyclerView1);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        FruitAdapter fruitAdapter = new FruitAdapter(getData());
        recyclerView.setAdapter(fruitAdapter);
    }
}
