package com.leedopoem.ljh.friendlyteacher.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;

/**
 * Created by ljh on 17-10-3.
 */

public class NetworkAvailableUtil {
    public static Boolean isAvailable(Context context){
        //获得所有手机连接管理
        ConnectivityManager connectivityManager= (ConnectivityManager) context.getSystemService
                (Context.CONNECTIVITY_SERVICE);
        //是否有一种可以连接
        if (connectivityManager==null){
            return false;
        }
        else
        {
            NetworkInfo networkInfos=connectivityManager.getActiveNetworkInfo();
            if (networkInfos!=null) {
                if (networkInfos.getState() == NetworkInfo.State.CONNECTED) {
                    return true;
                }

            }
        }
            return false;
    }
}
