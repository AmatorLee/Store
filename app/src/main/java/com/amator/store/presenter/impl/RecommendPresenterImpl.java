package com.amator.store.presenter.impl;

import com.amator.store.bean.AppRecommendBean;
import com.amator.store.bean.RecommendBean;
import com.amator.store.http.BaseObserver;
import com.amator.store.http.HttpCallBack;
import com.amator.store.http.HttpManager;
import com.amator.store.presenter.RecommentPresenter;
import com.amator.store.util.JsonParseUtils;
import com.amator.store.view.RecommendView;
import com.trello.rxlifecycle2.android.FragmentEvent;

import java.io.IOException;

import okhttp3.ResponseBody;

/**
 * Created by AmatorLee on 2017/11/24.
 */

public class RecommendPresenterImpl extends BaseFragmentPresenterImpl<RecommendView> implements RecommentPresenter<RecommendView> {

    @Override
    public void getRecommendData() {
        HttpManager.getInstance()
                .getRetrofitService()
                .getRecommendData()
                .compose(HttpManager.<ResponseBody>compose())
                .compose(getFragmentLifecyclerProvider().bindUntilEvent(FragmentEvent.PAUSE))
                .subscribe(new BaseObserver<ResponseBody>(new HttpCallBack<ResponseBody>() {
                    @Override
                    public void onSuccess(ResponseBody body) {
                        String result = "";
                        try {
                            result = body.string();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        RecommendBean recommendBean = JsonParseUtils.parseRecommendBean(result);
                        mView.getRecommentDataSuccess(recommendBean);
                    }

                    @Override
                    public void onError(String message) {
                        mView.getRecommentDataError(message);
                    }
                }));
    }
}
