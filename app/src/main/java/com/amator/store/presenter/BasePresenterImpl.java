package com.amator.store.presenter;

import com.amator.store.view.BaseView;

/**
 * Created by AmatorLee on 2017/11/23.
 */

public class BasePresenterImpl<T extends BaseView> implements BasePresenter<T> {

    private T mView;

    @Override
    public void attach(T baseView) {
        this.mView = baseView;
    }

    @Override
    public void detach() {
        this.mView = null;
    }
}
