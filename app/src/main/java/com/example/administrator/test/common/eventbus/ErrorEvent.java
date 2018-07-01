package com.example.administrator.test.common.eventbus;

/**
 * Created by Administrator on 2016/12/23.
 */
public class ErrorEvent {

    private String code;
    private String msg;
    private Object tag;

    public ErrorEvent(String code, String msg, Object tag) {
        super();
        this.code = code;
        this.msg = msg;
        this.tag = tag;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getTag() {
        return tag;
    }

    public void setTag(Object tag) {
        this.tag = tag;
    }
}
