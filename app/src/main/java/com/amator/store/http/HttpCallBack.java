package com.amator.store.http;

/**
 * Created by AmatorLee on 2017/11/23.
 * http回调类
 */

public interface HttpCallBack<T>{

    void onSuccess(T t);

    void onError(String message);

}
