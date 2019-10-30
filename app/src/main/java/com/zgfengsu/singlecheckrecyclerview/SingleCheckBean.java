package com.zgfengsu.singlecheckrecyclerview;

public class SingleCheckBean {
    private int id;
    private String msg;
    private boolean check;


    public SingleCheckBean(int id, String msg, boolean check) {
        this.id = id;
        this.msg = msg;
        this.check = check;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }
}
