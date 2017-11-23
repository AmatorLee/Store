package com.amator.store.presenter;

import com.amator.store.view.BaseView;

/**
 * Created by AmatorLee on 2017/11/23.
 */

public interface BasePresenter<T extends BaseView> {

    void attach(T baseView);

    void detach();


}
