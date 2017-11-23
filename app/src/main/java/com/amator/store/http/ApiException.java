package com.amator.store.http;

/**
 * Created by AmatorLee on 2017/11/23.
 */

public class ApiException extends Exception{

    private String message;
    private int code;


    public ApiException(int code,String message) {
        super(message);
        this.code = code;
    }


    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
