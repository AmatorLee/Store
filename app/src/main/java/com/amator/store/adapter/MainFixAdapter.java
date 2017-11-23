package com.amator.store.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.amator.store.R;

import java.util.List;

/**
 * Created by AmatorLee on 2017/11/23.
 */

public class MainFixAdapter extends FragmentPagerAdapter {


    private Context mContext;
    private List<Fragment> mFragments;

    public MainFixAdapter(Context context,FragmentManager fm,List<Fragment> fragments) {
        super(fm);
        this.mFragments = fragments;
        this.mContext  = context;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String[] names = mContext.getResources().getStringArray(R.array.tab_name);
        return names[position];
    }
}
