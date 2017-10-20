package com.leedopoem.ljh.friendlyteacher.data.source.remote.retrofit;

import android.widget.Toast;

import com.leedopoem.ljh.friendlyteacher.base.MyApplication;

/**
 * Created by ljh on 17-10-20.
 */

public class ExceptionHandler {
    public static void netWorkError(Exception e){
        Toast.makeText(MyApplication.INSTANCE,"Http Error",Toast.LENGTH_SHORT).show();
    }
}
