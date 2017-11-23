package com.amator.store.base;

/**
 * Created by AmatorLee on 2017/11/23.
 * 基类回调
 */

public interface IBaseListener {


    /***
     * 初始化数据
     */
    void initData();

    /**
     * 初始化监听
     */
    void initListener();

    /**
     * 初始化事件
     */
    void initEvent();


    /***
     * 弹土司
     * @param message
     */
    void showToast(String message);

}
