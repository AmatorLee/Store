package com.amator.store.view.activity;

import android.content.Intent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.amator.store.R;
import com.amator.store.base.BaseActivity;
import com.amator.store.presenter.BaseActivityPresenter;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by AmatorLee on 2017/11/23.
 */

public class SplashActivity extends BaseActivity{

    @BindView(R.id.btn_toMain)
    Button mBtnToMain;
    @BindView(R.id.img_toMain)
    ImageView mImgToMain;
    private Animation mImgAnimation;
    private Animation.AnimationListener mImgAnimationListener;


    @Override
    public void initData() {
        mBtnToMain.setEnabled(false);
        mImgAnimation = AnimationUtils.loadAnimation(this, R.anim.splash_enter);
    }

    @Override
    public void initListener() {
        mImgAnimationListener = new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                mBtnToMain.setEnabled(true);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        };
    }

    @Override
    public void initEvent() {
        mImgAnimation.setAnimationListener(mImgAnimationListener);
        mImgToMain.setAnimation(mImgAnimation);
        mImgAnimation.start();
    }

    @OnClick(R.id.btn_toMain)
    public void onClick(){
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected BaseActivityPresenter initPresenter() {
        return null;
    }

    @Override
    public void showError(String message) {
        showToast(message);
    }
}
