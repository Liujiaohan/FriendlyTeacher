package com.leedopoem.ljh.friendlyteacher.base;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.leedopoem.ljh.friendlyteacher.data.entity.DaoMaster;
import com.leedopoem.ljh.friendlyteacher.data.entity.DaoSession;


/**
 * Created by ljh on 17-9-27.
 */

public class MyApplication extends Application {
    private static MyApplication INSTANCE=null;
    private SQLiteDatabase mDB;
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;
    private DaoMaster.DevOpenHelper mHelper;

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE=this;
        setDatabase();
    }

    private void setDatabase() {
        mHelper=new DaoMaster.DevOpenHelper(this,"friendlyteacher.db",null);
        mDB=mHelper.getWritableDatabase();
        mDaoMaster=new DaoMaster(mDB);
        mDaoSession=mDaoMaster.newSession();
    }

    public static MyApplication getINSTANCE() {
        return INSTANCE;
    }

    public SQLiteDatabase getmDB() {
        return mDB;
    }

    public DaoSession getmDaoSession() {
        return mDaoSession;
    }
}
