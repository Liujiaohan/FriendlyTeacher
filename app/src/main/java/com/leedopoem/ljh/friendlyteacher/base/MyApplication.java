package com.leedopoem.ljh.friendlyteacher.base;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import io.realm.Realm;
import io.realm.RealmConfiguration;


/**
 * Created by ljh on 17-9-27.
 */

public class MyApplication extends Application {
    public static MyApplication INSTANCE=null;
    private SQLiteDatabase mDB;

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE=this;
        RealmConfiguration configuration=new RealmConfiguration.Builder(this).build();
        Realm.setDefaultConfiguration(configuration);
    }


    public static MyApplication getINSTANCE() {
        return INSTANCE;
    }
}
