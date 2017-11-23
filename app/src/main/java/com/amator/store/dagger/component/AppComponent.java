package com.amator.store.dagger.component;

import android.content.Context;

import com.amator.store.base.Constants;
import com.amator.store.dagger.module.AppModule;
import com.amator.store.dagger.scope.ContextLife;
import com.amator.store.dagger.scope.PerApp;

import dagger.Component;

/**
 * Created by AmatorLee on 2017/11/23.
 * 提供全局的Context
 */
@PerApp
@Component(modules = AppModule.class)
public interface AppComponent {

    @ContextLife(Constants.APPLICATION)
    Context getApplicationContext();
}
