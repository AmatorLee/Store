package com.amator.store;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.amator.store.adapter.MainFixAdapter;
import com.amator.store.base.BaseActivity;
import com.amator.store.fragment.ClassificationFragment;
import com.amator.store.fragment.MineFragment;
import com.amator.store.fragment.RankingFragment;
import com.amator.store.fragment.RecommendFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

import static android.os.Build.VERSION_CODES.M;

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
}
