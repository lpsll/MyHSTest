package com.example.administrator.test.Order.entity;

/**
 * Created by lenovo on 2016/12/25.
 */
public class OrderEvent {
    private String msg;
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    public OrderEvent(String msg) {
        super();
        this.msg = msg;
    }
}
