package com.amator.store.presenter;

import com.amator.store.view.BaseView;

/**
 * Created by AmatorLee on 2017/11/24.
 */

public interface RecommentPresenter<T extends BaseView> extends BasePresenter<T>{


    void getRecommendData();

}
