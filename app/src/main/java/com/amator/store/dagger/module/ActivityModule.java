package com.amator.store.dagger.module;

import android.app.Activity;
import android.content.Context;

import com.amator.store.base.Constants;
import com.amator.store.dagger.scope.ContextLife;
import com.amator.store.dagger.scope.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by AmatorLee on 2017/11/23.
 */
@Module
public class ActivityModule {

    private Activity mActivity;

    public ActivityModule(Activity activity) {
        mActivity = activity;
    }

    @Provides
    @PerActivity
    public Activity provideActivity(){
        return mActivity;
    }

    @Provides
    @PerActivity
    @ContextLife(Constants.ACTIVITY)
    public Context provideContext(){
        return mActivity;
    }

}
