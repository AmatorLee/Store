package com.amator.store.dagger.module;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;

import com.amator.store.base.Constants;
import com.amator.store.dagger.scope.ContextLife;
import com.amator.store.dagger.scope.PerActivity;
import com.amator.store.dagger.scope.PerFragment;

import dagger.Module;
import dagger.Provides;

/**
 * Created by AmatorLee on 2017/11/23.
 */
@Module
public class FragmentModule {

    private Fragment mFragment;

    public FragmentModule(Fragment fragment) {
        mFragment = fragment;
    }

    @Provides
    @PerFragment
    public Fragment provideFragment(){
        return mFragment;
    }

    @Provides
    @PerFragment
    public Activity provideFragmentActivity(){
        return mFragment.getActivity();
    }

    @Provides
    @PerFragment
    @ContextLife(Constants.ACTIVITY)
    public Context provideContext(){
        return mFragment.getContext();
    }

}

