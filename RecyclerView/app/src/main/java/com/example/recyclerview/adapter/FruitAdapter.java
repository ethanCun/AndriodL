package com.example.recyclerview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.R;
import com.example.recyclerview.entity.Fruit;

import java.util.List;

//自定义的Adapter继承与RecycleView的Adapter
public class FruitAdapter extends RecyclerView.Adapter {

    private List<Fruit> fruits;

    //构造方法， 用来接受外部传入的数据列表
    public FruitAdapter(List<Fruit> fruits){
        this.fruits = fruits;
    }

    //用于创建ViewHolder
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_item, parent, false);
        return new ViewHolder(view);
    }

    //用户赋值, 在每个子项滚动到屏幕内的时候执行
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Fruit fruit = this.fruits.get(position);

        FruitAdapter.ViewHolder viewHolder = (FruitAdapter.ViewHolder)holder;
        viewHolder.imgv.setImageResource(R.drawable.ic_launcher_background);
        viewHolder.tv.setText(fruit.getName());
    }

    @Override
    public int getItemCount() {
        return this.fruits.size();
    }

    //定义一个内部类
    private class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView imgv;
        public TextView tv;

        public ImageView getImgv() {
            return imgv;
        }

        public TextView getTv() {
            return tv;
        }

        //这个itemView相当于iOS的cell
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            this.imgv = (ImageView) itemView.findViewById(R.id.imgv);
            this.tv = (TextView)itemView.findViewById(R.id.tv);
        }
    }


}
