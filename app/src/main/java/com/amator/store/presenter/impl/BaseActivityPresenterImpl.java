package com.amator.store.presenter.impl;

import android.content.Context;

import com.amator.store.presenter.BaseActivityPresenter;
import com.amator.store.view.BaseView;
import com.trello.rxlifecycle2.LifecycleProvider;

/**
 * Created by AmatorLee on 2017/11/24.
 */

public class BaseActivityPresenterImpl<T extends BaseView>  extends BasePresenterImpl<T> implements BaseActivityPresenter<T> {

    private Context mContext;

    @Override
    public void detach() {
        super.detach();
        mContext = null;
    }

    @Override
    public void attach(Context context, T baseView) {
       super.attach(baseView);
        mContext = context;
    }

    public LifecycleProvider getActivityLifecyclerProvider(){
        LifecycleProvider provider = null;
        if (mContext != null && mContext instanceof LifecycleProvider){
            provider = (LifecycleProvider) mContext;
        }
        return provider;
    }

}
