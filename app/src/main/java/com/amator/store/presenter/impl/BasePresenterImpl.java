package com.amator.store.presenter.impl;

import com.amator.store.presenter.BasePresenter;
import com.amator.store.view.BaseView;

/**
 * Created by AmatorLee on 2017/11/23.
 */

public class BasePresenterImpl<T extends BaseView> implements BasePresenter<T> {

    protected T mView;

    @Override
    public void attach(T baseView) {
        this.mView = baseView;
    }

    @Override
    public void detach() {
        this.mView = null;
    }
}
