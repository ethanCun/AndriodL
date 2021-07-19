package com.example.exciseui.entity;

public class Msg {

    private String content;

    //1表示接受的消息 2表示发送的消息
    private Integer type;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
