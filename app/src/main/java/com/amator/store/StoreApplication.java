package com.amator.store;

import android.app.Application;
import android.os.Handler;

import com.amator.store.dagger.component.AppComponent;
import com.amator.store.dagger.component.DaggerAppComponent;
import com.amator.store.dagger.module.AppModule;

/**
 * Created by AmatorLee on 2017/11/23.
 */

public class StoreApplication extends Application {

    private static AppComponent mAppComponent;
    private Handler mMainHandler;

    @Override
    public void onCreate() {
        super.onCreate();
        initApplicationComponent();
        mMainHandler = new Handler(getMainLooper());
    }

    public Handler getMainHandler() {
        return mMainHandler;
    }

    public static AppComponent getAppComponent() {
        return mAppComponent;
    }

    public void initApplicationComponent() {
        mAppComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }
}
