package com.amator.store.view;

import com.amator.store.bean.RecommendBean;

/**
 * Created by AmatorLee on 2017/11/24.
 */

public interface RecommendView extends BaseView {

    void getRecommentDataSuccess(RecommendBean recommendBean);


    void getRecommentDataError(String message);

}
