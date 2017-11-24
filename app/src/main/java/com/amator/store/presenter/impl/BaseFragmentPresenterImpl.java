package com.amator.store.presenter.impl;

import com.amator.store.base.BaseFragment;
import com.amator.store.presenter.BaseFragmentPresenter;
import com.amator.store.view.BaseView;
import com.trello.rxlifecycle2.LifecycleProvider;

/**
 * Created by AmatorLee on 2017/11/24.
 */

public class BaseFragmentPresenterImpl<T extends BaseView> extends BasePresenterImpl<T> implements BaseFragmentPresenter<T> {


    private BaseFragment mBaseFragment;


    @Override
    public void attach(BaseFragment baseFragment, T baseView) {
        super.attach(baseView);
        mBaseFragment = baseFragment;
    }

    

    public LifecycleProvider getFragmentLifecyclerProvider(){
        LifecycleProvider provider = null;
        if (mBaseFragment!= null&& mBaseFragment instanceof LifecycleProvider){
            provider = mBaseFragment;
        }
        return provider;
    }



    @Override
    public void detach() {
        super.detach();
        mBaseFragment = null;
    }
}
