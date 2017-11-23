package com.amator.store.http;

import com.amator.store.R;
import com.amator.store.StoreApplication;
import com.amator.store.base.Constants;
import com.google.gson.JsonParseException;

import java.net.ConnectException;
import java.net.ServerSocket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownServiceException;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import retrofit2.HttpException;

/**
 * Created by AmatorLee on 2017/11/23.
 */

public class CustomObserver<T> implements Observer<T> {

    private  HttpCallBack callBack;

    public CustomObserver(HttpCallBack callBack){
        this.callBack = callBack;
    }



    @Override
    public void onSubscribe(@NonNull Disposable d) {

    }

    @Override
    public void onNext(@NonNull T t) {
        callBack.onSuccess(t);
    }

    @Override
    public void onError(@NonNull Throwable e) {
        ApiException exception;
        if (e instanceof HttpException || e instanceof ConnectException|| e instanceof SocketTimeoutException || e instanceof SocketException){
            String message = StoreApplication.getAppComponent().getApplicationContext().getString(R.string.txt_net_exception);
            exception = new ApiException(Constants.HTTP_EX,message);
        }else if (e instanceof JsonParseException){
            String message = StoreApplication.getAppComponent().getApplicationContext().getString(R.string.txt_parse_exception);
            exception = new ApiException(Constants.PARSE_EX,message);
        }else {
            String message = StoreApplication.getAppComponent().getApplicationContext().getString(R.string.txt_unkown_exception);
            exception = new ApiException(Constants.UNKONWN_EX,message);
        }
        this.callBack.onError(exception.getMessage());
    }

    @Override
    public void onComplete() {

    }
}
