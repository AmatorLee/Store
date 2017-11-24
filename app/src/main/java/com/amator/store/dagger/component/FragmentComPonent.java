package com.amator.store.dagger.component;

import android.app.Activity;
import android.content.Context;

import com.amator.store.base.Constants;
import com.amator.store.dagger.module.FragmentModule;
import com.amator.store.dagger.scope.ContextLife;
import com.amator.store.dagger.scope.PerFragment;
import com.amator.store.view.fragment.ClassificationFragment;
import com.amator.store.view.fragment.MineFragment;
import com.amator.store.view.fragment.RankingFragment;
import com.amator.store.view.fragment.RecommendFragment;

import dagger.Component;

/**
 * Created by AmatorLee on 2017/11/23.
 */
@PerFragment
@Component(modules = FragmentModule.class,dependencies = AppComponent.class)
public interface FragmentComPonent {


    @ContextLife(Constants.ACTIVITY)
    Context getAcivityContext();

    @ContextLife(Constants.APPLICATION)
    Context getApplicationContext();

    Activity getActivity();

    void inject(RecommendFragment fragment);

    void inject(ClassificationFragment fragment);

    void inject(RankingFragment fragment);


    void inject(MineFragment fragment);

}
