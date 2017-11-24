package com.amator.store.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.amator.store.StoreApplication;
import com.amator.store.dagger.component.DaggerFragmentComPonent;
import com.amator.store.dagger.component.FragmentComPonent;
import com.amator.store.dagger.module.FragmentModule;
import com.amator.store.presenter.BaseFragmentPresenter;
import com.amator.store.presenter.BasePresenter;
import com.amator.store.view.BaseView;
import com.trello.rxlifecycle2.components.support.RxFragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;

import static butterknife.ButterKnife.bind;

/**
 * Created by AmatorLee on 2017/11/23.
 * 基类fragment
 */

public abstract class BaseFragment<T extends BaseFragmentPresenter> extends RxFragment implements IBaseListener ,BaseView{

    protected View mView;
    private Unbinder mUnbinder;
    protected T mPresenter;
    protected FragmentComPonent mFragmentComponent;
    protected boolean isCreate;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (mView == null) {
            mView = inflater.inflate(getLayoutId(), container, false);
            isCreate = true;
            mUnbinder = ButterKnife.bind(this, mView);
        }
        initFragmentComponent();
        mPresenter = initPresenter();
        if (mPresenter!= null){
            mPresenter.attach(this,this);
        }
        initData();
        initListener();
        initEvent();
        return mView;
    }

    protected abstract T initPresenter();

    protected void initFragmentComponent(){
        mFragmentComponent = DaggerFragmentComPonent.builder()
                .fragmentModule(new FragmentModule(this))
                .appComponent(((StoreApplication)getActivity().getApplication()).getAppComponent())
                .build();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mUnbinder != null) {
            mUnbinder.unbind();
        }
        if (mPresenter != null){
            mPresenter.detach();
        }
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    protected abstract int getLayoutId();
}
