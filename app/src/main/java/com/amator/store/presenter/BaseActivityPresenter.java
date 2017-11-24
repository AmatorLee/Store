package com.amator.store.presenter;

import android.content.Context;

import com.amator.store.view.BaseView;

/**
 * Created by AmatorLee on 2017/11/24.
 */

public interface BaseActivityPresenter<T extends BaseView> extends BasePresenter<T> {

    void attach(Context context,T baseView);


}
