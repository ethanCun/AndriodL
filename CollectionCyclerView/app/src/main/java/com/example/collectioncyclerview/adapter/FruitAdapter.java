package com.example.collectioncyclerview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.collectioncyclerview.R;
import com.example.collectioncyclerview.entity.Fruit;

import java.util.List;

//自定义Adapter
public class FruitAdapter extends RecyclerView.Adapter {

    private List<Fruit> fruits;

    public FruitAdapter(List<Fruit> fruits){
        this.fruits = fruits;
    }

    private class Viewholder extends RecyclerView.ViewHolder {

        private ImageView imgv;
        private TextView tv;

        public ImageView getImgv() {
            return imgv;
        }

        public TextView getTv() {
            return tv;
        }

        public Viewholder(@NonNull View itemView) {
            super(itemView);

            this.imgv = itemView.findViewById(R.id.imgv);
            this.tv = itemView.findViewById(R.id.tv);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, int viewType) {

        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_item, parent, false);

        //RecyclerView的点击时间
        Viewholder viewholder = new Viewholder(view);

        //itemView代表是最外层布局
        viewholder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(parent.getContext(), "点击了itemView", Toast.LENGTH_LONG).show();
            }
        });

//        viewholder.getImgv().setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(parent.getContext(), "点击了图片", Toast.LENGTH_LONG).show();
//            }
//        });
//
//        viewholder.getTv().setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Toast.makeText(parent.getContext(), "点击了TextView", Toast.LENGTH_LONG).show();
//            }
//        });

        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        FruitAdapter.Viewholder viewholder = (FruitAdapter.Viewholder)holder;
        viewholder.imgv.setImageResource(R.drawable.ic_launcher_background);
        viewholder.tv.setText(this.fruits.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return this.fruits.size();
    }
}
