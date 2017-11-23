package com.amator.store.dagger.module;

import android.content.Context;

import com.amator.store.StoreApplication;
import com.amator.store.base.Constants;
import com.amator.store.dagger.scope.ContextLife;
import com.amator.store.dagger.scope.PerApp;

import dagger.Module;
import dagger.Provides;

/**
 * Created by AmatorLee on 2017/11/23.
 */

@Module
public class AppModule {

    private StoreApplication mStoreApplication;

    public AppModule(StoreApplication storeApplication) {
        mStoreApplication = storeApplication;
    }

    @Provides
    @PerApp
    @ContextLife(Constants.APPLICATION)
    public Context provideApplication(){
        return mStoreApplication.getApplicationContext();
    }
}
