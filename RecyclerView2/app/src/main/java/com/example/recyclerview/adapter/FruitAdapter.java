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

//自定义继承于androidx.recyclerview.widget.RecyclerView的adapter
public class FruitAdapter extends RecyclerView.Adapter {

    //填充数据
    private List<Fruit> fruits;

    public FruitAdapter(List<Fruit> fruits){
        this.fruits = fruits;
    }

    //缓存池
    private class ViewHolder extends RecyclerView.ViewHolder{

        //内部控件
        private ImageView img;
        private TextView tv;

        public ImageView getImg() {
            return img;
        }

        public TextView getTv() {
            return tv;
        }

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            this.img = itemView.findViewById(R.id.imgv);
            this.tv = itemView.findViewById(R.id.tv);
        }
    }

    //构建ViewHolder
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_item, parent, false);
        return new ViewHolder(view);
    }

    //赋值
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Fruit fruit = this.fruits.get(position);

        FruitAdapter.ViewHolder viewHolder = (FruitAdapter.ViewHolder)holder;
        viewHolder.getImg().setImageResource(R.drawable.ic_launcher_background);
        viewHolder.getTv().setText(fruit.getName());
    }

    @Override
    public int getItemCount() {

        return this.fruits.size();
    }
}
