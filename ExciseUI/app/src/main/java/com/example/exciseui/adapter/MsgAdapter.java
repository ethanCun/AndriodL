package com.example.exciseui.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.exciseui.R;
import com.example.exciseui.entity.Msg;

import java.util.List;

public class MsgAdapter extends RecyclerView.Adapter {


    //消息列表
    private List<Msg> msgList;

    public MsgAdapter(List<Msg> data){
        super();
        this.msgList = data;
    }

    //重写getItemViewType, 在绑定的时候根据这个viewType来加载不容的cell
    @Override
    public int getItemViewType(int position) {
        return this.msgList.get(position).getType();
    }

    //左边视图缓存
    private class LeftViewHolder extends RecyclerView.ViewHolder{

        private TextView leftView;

        public TextView getLeftView() {
            return leftView;
        }

        public LeftViewHolder(@NonNull View itemView) {
            super(itemView);
            this.leftView = itemView.findViewById(R.id.leftView);
        }
    }

    //右边视图缓存
    private class RightViewHolder extends RecyclerView.ViewHolder{

        private TextView rightView;

        public TextView getRightView() {
            return rightView;
        }

        public RightViewHolder(@NonNull View itemView) {
            super(itemView);

            this.rightView = itemView.findViewById(R.id.rightView);
        }
    }

    //根据消息消息类型绑定缓存池
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Log.i("czy", "viewType=" + viewType);

        //1表示接受的消息 2表示发送的消息
        if (viewType == 2){

            //接受的消息绑定msg_right_item
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_right_item, parent, false);
            return new RightViewHolder(view);
        }else {

            //发送的消息绑定msg_left_item
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.msg_left_item, parent, false);
            return new LeftViewHolder(view);
        }
    }

    //设置cell
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Msg msg = this.msgList.get(position);

        if (holder instanceof RightViewHolder){
            RightViewHolder rightViewHolder = (RightViewHolder)holder;
            rightViewHolder.getRightView().setText(msg.getContent());
        }else if (holder instanceof LeftViewHolder){
            LeftViewHolder leftViewHolder = (LeftViewHolder)holder;
            leftViewHolder.getLeftView().setText(msg.getContent());
        }

    }

    @Override
    public int getItemCount() {
        return this.msgList.size();
    }
}
