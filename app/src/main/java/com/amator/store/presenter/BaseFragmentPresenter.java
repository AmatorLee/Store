package com.amator.store.presenter;

import com.amator.store.base.BaseFragment;
import com.amator.store.view.BaseView;

/**
 * Created by AmatorLee on 2017/11/24.
 */

public interface BaseFragmentPresenter<T extends BaseView> extends BasePresenter<T> {

    void attach(BaseFragment baseFragment,T baseView);

}
