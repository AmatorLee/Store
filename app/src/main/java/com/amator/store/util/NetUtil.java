package com.amator.store.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;

/**
 * Created by AmatorLee on 2017/11/23.
 * 网络接口工具类
 */

public class NetUtil {

    /***
     * 判断网络是否连接
     * @param context
     * @return
     */
    public static boolean isNetConnected(Context context){
        ConnectivityManager manager = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo network = manager.getActiveNetworkInfo();
        if (network != null && network.isAvailable() && network.isConnected()){
            return true;
        }
        return false;
    }


    /***
     * 是否WII连接
     * @param context
     * @return
     */
    public static boolean isWifi(Context context){
        ConnectivityManager manager = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo network = manager.getActiveNetworkInfo();
       if (network != null && network.getType() == ConnectivityManager.TYPE_WIFI){
           return true;
       }
       return false;
    }


}
