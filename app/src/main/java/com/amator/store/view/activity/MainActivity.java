package com.amator.store.view.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.amator.store.R;
import com.amator.store.adapter.MainFixAdapter;
import com.amator.store.base.BaseActivity;
import com.amator.store.view.fragment.ClassificationFragment;
import com.amator.store.view.fragment.MineFragment;
import com.amator.store.view.fragment.RankingFragment;
import com.amator.store.view.fragment.RecommendFragment;
import com.amator.store.presenter.BaseActivityPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.tablayout_main)
    TabLayout mMainTabLayout;
    @BindView(R.id.viewpager_main)
    ViewPager mMainViewPager;
    public static final String TAG = "MainActivity";
    private List<Fragment> mFragments;

    private MainFixAdapter mAdapter;


    @Override
    public void initData() {
        mFragments = new ArrayList<>();
        mFragments.add(new RecommendFragment());
        mFragments.add(new ClassificationFragment());
        mFragments.add(new RankingFragment());
        mFragments.add(new MineFragment());
        mAdapter = new MainFixAdapter(this, getSupportFragmentManager(), mFragments);
    }

    @Override
    public void initListener() {
    }

    @Override
    public void initEvent() {
        mMainViewPager.setAdapter(mAdapter);
        mMainTabLayout.setupWithViewPager(mMainViewPager);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected BaseActivityPresenter initPresenter() {
        return null;
    }


    @Override
    public void showError(String message) {
        showToast(message);
    }
}
