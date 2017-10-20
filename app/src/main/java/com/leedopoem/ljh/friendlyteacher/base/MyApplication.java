package com.leedopoem.ljh.friendlyteacher.base;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import io.realm.Realm;
import io.realm.RealmConfiguration;


/**
 * Created by ljh on 17-9-27.
 */

public class MyApplication extends Application {
    private static Context context;
    public static MyApplication INSTANCE=null;
    private SQLiteDatabase mDB;

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE=this;
        context = getApplicationContext();
        RealmConfiguration configuration=new RealmConfiguration.Builder(this).build();
        Realm.setDefaultConfiguration(configuration);
    }

    public static Context getContext() {
        return context;
    }

    public static MyApplication getINSTANCE() {
        return INSTANCE;
    }
}
