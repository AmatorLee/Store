package com.amator.store.http;

import com.amator.store.StoreApplication;
import com.amator.store.base.Constants;
import com.amator.store.util.NetUtil;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by AmatorLee on 2017/11/23.
 * 网络管理类
 */

public class HttpManager {
    private static volatile HttpManager mInstance;
    private  HttpService mRetrofitService;
    private Retrofit mRetrofit;
    private static int mCacheSize = 50 * 1024 * 1024;
    private static File mCacheFile = new File(StoreApplication.getAppComponent().getApplicationContext().getCacheDir(), "storeCache");
    private static Cache cache = new Cache(mCacheFile,mCacheSize);
    private static Interceptor mCacheInterceptor = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            if (!NetUtil.isNetConnected(StoreApplication.getAppComponent().getApplicationContext())) {
                request.newBuilder()
                        .cacheControl(CacheControl.FORCE_CACHE)
                        .build();
            }
            Response resultResponse = chain.proceed(chain.request());
            if (NetUtil.isNetConnected(StoreApplication.getAppComponent().getApplicationContext())) {
                return resultResponse.newBuilder()
                        .header("Cache-Control", "public,max-age=" + 0)
                        .removeHeader("Pragma")
                        .build();
            } else {
                int age = 24 * 60 * 60;
                return resultResponse.newBuilder()
                        .header("Cache-Control", "public, only-if-cache, max-stale" + age)
                        .removeHeader("Pragma")
                        .build();
            }
        }
    };

    private HttpManager() {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .connectTimeout(30, TimeUnit.SECONDS)
                .cache(cache)
                .addInterceptor(mCacheInterceptor)
                .build();
        mRetrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constants.BASE_URL)
                .client(client)
                .build();
    }

    public HttpService getRetrofitService(){
        mRetrofitService = mRetrofit.create(HttpService.class);
        return mRetrofitService;
    }

    public static HttpManager getInstance() {
        if (mInstance == null) {
            synchronized (HttpManager.class) {
                if (mInstance == null) {
                    mInstance = new HttpManager();
                }
            }
        }
        return mInstance;
    }


    /**
     * 线程转换
     * @param <T>
     * @return
     */
   public static <T> ObservableTransformer<T,T> compose(){
       return new ObservableTransformer<T, T>() {
           @Override
           public ObservableSource<T> apply(@NonNull Observable<T> upstream) {
               return upstream
                       .subscribeOn(Schedulers.io())
                       .unsubscribeOn(Schedulers.io())
                       .observeOn(AndroidSchedulers.mainThread());
           }
       };
   }


}
