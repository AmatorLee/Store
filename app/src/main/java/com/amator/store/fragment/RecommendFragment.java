package com.amator.store.fragment;

import com.amator.store.R;
import com.amator.store.base.BaseFragment;
import com.amator.store.presenter.BasePresenter;

/**
 * Created by AmatorLee on 2017/11/23.
 * 推荐Fragment
 */

public class RecommendFragment extends BaseFragment{


    @Override
    public void initData() {

    }

    @Override
    public void initListener() {

    }

    @Override
    public void initEvent() {

    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_recomment;
    }

    @Override
    public void showError(String message) {
        showToast(message);
    }
}
