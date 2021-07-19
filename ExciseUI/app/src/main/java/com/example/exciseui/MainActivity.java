package com.example.exciseui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.exciseui.adapter.MsgAdapter;
import com.example.exciseui.entity.Msg;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //消息列表
    private List<Msg> msgs = new ArrayList<>();
    //消息适配器
    private MsgAdapter msgAdapter;

    private List<Msg> getData(){

        for (int i = 0; i < 20; i++) {

            Msg msg = new Msg();
            msg.setContent("msg" + (i+1));
            msg.setType(i%2+1);
            msgs.add(msg);
        }

        return msgs;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        final MsgAdapter msgAdapter = new MsgAdapter(this.getData());
        this.msgAdapter = msgAdapter;

        final RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(msgAdapter);

        Button sendBtn = (Button)findViewById(R.id.send);
        final EditText editText = (EditText)findViewById(R.id.inputText);
        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String content = editText.getText().toString();
                if (!content.isEmpty()){
                    Msg msg = new Msg();
                    msg.setType(2);
                    msg.setContent(content);
                    msgs.add(msg);

                    //添加消息后刷表
                    msgAdapter.notifyItemInserted(msgs.size()-1);
                    //滚动到最后一行
                    recyclerView.scrollToPosition(msgs.size()-1);
                    //清空编辑框的内容
                    editText.setText("");
                }
            }
        });
    }
}
