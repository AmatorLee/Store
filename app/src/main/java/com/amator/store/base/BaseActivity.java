package com.amator.store.base;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.amator.store.StoreApplication;
import com.amator.store.dagger.component.ActivityComponent;
import com.amator.store.dagger.component.DaggerActivityComponent;
import com.amator.store.dagger.module.ActivityModule;
import com.amator.store.presenter.BaseActivityPresenter;
import com.amator.store.presenter.BasePresenter;
import com.amator.store.util.ActivityManager;
import com.amator.store.util.StatusTextUtil;
import com.amator.store.view.BaseView;
import com.readystatesoftware.systembartint.SystemBarTintManager;
import com.trello.rxlifecycle2.components.RxActivity;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by AmatorLee on 2017/11/23.
 */

public abstract class BaseActivity<T extends BaseActivityPresenter> extends RxAppCompatActivity implements IBaseListener,BaseView{

    private Unbinder mUnbinder;
    protected ActivityComponent mActivityComponent;
    protected T mPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设为竖屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ActivityManager.getInstance().pushActivity(this);
        setContentView(getLayoutId());
        if (Build.VERSION.SDK_INT >=Build.VERSION_CODES.KITKAT){
            setStatusBar(true);
        }
        mUnbinder = ButterKnife.bind(this);
        initActivityComponent();
        mPresenter = initPresenter();
        if (mPresenter!= null){
            mPresenter.attach(this,this);
        }
        initData();
        initListener();
        initEvent();

    }

    private void setStatusBar(boolean on) {
        //状态栏字体设为深色
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility( View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        StatusTextUtil.FlymeSetStatusBarLightMode(getWindow(),true);
        StatusTextUtil.MIUISetStatusBarLightMode(this,true);
        Window win = getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
        SystemBarTintManager manager = new SystemBarTintManager(this);
        manager.setStatusBarTintEnabled(true);
        manager.setStatusBarTintColor(Color.WHITE);
    }

    protected abstract int getLayoutId();


    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityManager.getInstance().popActivity(this);
        if (mUnbinder != null){
            mUnbinder.unbind();
        }
        if (mPresenter != null){
            mPresenter.detach();
        }
    }

    public void initActivityComponent(){
        mActivityComponent = DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .appComponent(((StoreApplication) getApplication()).getAppComponent())
                .build();
    }


    @Override
    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    protected abstract T initPresenter();

    protected void startActivity(Class c){
        startActivity(new Intent(this,c));
    }
}
