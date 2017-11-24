package com.amator.store.view.fragment;

import com.amator.store.base.BaseFragment;
import com.amator.store.presenter.BaseFragmentPresenter;

/**
 * Created by AmatorLee on 2017/11/23.
 * 懒加载Fragment
 */

public abstract class LazyFragment<T extends BaseFragmentPresenter> extends BaseFragment<T>{

    private boolean hasLoad = false;

    private boolean isVisiable;

    @Override
    public void initData() {
        lazyData();
    }

    private void lazyData() {
        if (isVisiable && !hasLoad && isCreate){
            loadData();
            hasLoad = true;
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()){
            isVisiable = isVisibleToUser;
            lazyData();
        }
    }

    protected abstract void loadData();
}
