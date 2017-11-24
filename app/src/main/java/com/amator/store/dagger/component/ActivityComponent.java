package com.amator.store.dagger.component;

import android.app.Activity;
import android.content.Context;

import com.amator.store.view.activity.MainActivity;
import com.amator.store.base.Constants;
import com.amator.store.dagger.module.ActivityModule;
import com.amator.store.dagger.scope.ContextLife;
import com.amator.store.dagger.scope.PerActivity;

import dagger.Component;

/**
 * Created by AmatorLee on 2017/11/23.
 */
@PerActivity
@Component(modules = ActivityModule.class,dependencies = AppComponent.class)
public interface ActivityComponent {

    @ContextLife(Constants.ACTIVITY)
    Context getActivityContext();


    @ContextLife(Constants.APPLICATION)
    Context getApplicationContext();


    Activity getActivity();

    void inJect(MainActivity mainActivity);
}
