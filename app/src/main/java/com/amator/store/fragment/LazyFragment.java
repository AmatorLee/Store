package com.amator.store.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.amator.store.base.BaseFragment;
import com.amator.store.base.IBaseListener;
import com.amator.store.presenter.BasePresenter;
import com.amator.store.view.BaseView;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by AmatorLee on 2017/11/23.
 * 懒加载Fragment
 */

public abstract class LazyFragment<T extends BasePresenter> extends BaseFragment<T>{

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
