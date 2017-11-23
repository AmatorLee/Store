package com.amator.store.model;

import java.io.Serializable;

/**
 * Created by AmatorLee on 2017/11/23.
 */

public class BaseEntity<T> implements Serializable{

    private int ret;
    private String msg;
    private T data;


    public int getRet() {
        return ret;
    }

    public void setRet(int ret) {
        this.ret = ret;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
