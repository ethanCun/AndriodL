package com.example.listview.adapter;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.listview.R;
import com.example.listview.entity.Fruit;

import java.util.List;

//自定义ListView适配器
public class FruitAdapter extends ArrayAdapter<Fruit> {

    //传入参数
    //上下文
    private Context activity;
    //资源id
    private int resource;
    //列表数据
    private List<Fruit> fruits;


    public FruitAdapter(@NonNull Context context, int resource, List<Fruit> data) {
        super(context, resource, data);

        Log.i("czy", "调用了自定义适配器的构造方法");

        this.activity = context;
        this.resource = resource;
        this.fruits = data;
    }


    //getView方法会在子项被滚动的时候调用
    //第一个参数： listView数据对应的下标
    //第二个参数： 缓存当前视图的对象
    //第三个参数： 父级activity
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Log.i("czy", "调用了getView方法...");

        //静态获取LayoutInflater对象， 并装载列表视图， false表示只让父布局中声明的layout生效，不会为这个view添加父布局
        //因为view有了父布局就不能再添加到ListView中了
        View view;
        //缓存view内部组件
        FruitAdapter.ViewHolder viewHolder;

        //复用缓存的convertView
        if (convertView == null){

            view = LayoutInflater.from(this.activity).inflate(this.resource, parent, false);

            //获取列表视图上的组件 并记录到缓存对象
            ImageView imgv = (ImageView)view.findViewById(R.id.fruit_img);
            TextView tv = (TextView)view.findViewById(R.id.fruit_name);
            viewHolder = new ViewHolder(imgv, tv);

            //设置当前view的缓存对象
            view.setTag(viewHolder);

        }else {

            //记录缓存对象
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }


        //获取当前项的数据
        Fruit fruit = this.fruits.get(position);

        if (fruit != null){
            viewHolder.getImgv().setImageURI(Uri.parse("https://img2.baidu.com/it/u=3873017710,4199400239&fm=26&fmt=auto&gp=0.jpg"));
            viewHolder.getTv().setText(fruit.getName());
        }

        return view;
    }

    //新建内部类用来缓存fruit对象上的空间
    private class ViewHolder{

        private ImageView imgv;
        private TextView tv;

        public ImageView getImgv() {
            return imgv;
        }

        public TextView getTv() {
            return tv;
        }

        public ViewHolder(ImageView imgv, TextView tv){
            this.imgv = imgv;
            this.tv = tv;
        }
    }
}
