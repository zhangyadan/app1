package com.example.shappingb;

import android.app.Application;

import com.example.shappingb.db.DaoMaster;
import com.example.shappingb.db.DaoSession;

/**
 * Created by 张亚丹 on 2019/6/21.
 */

public class MyAppliction extends Application {
    private static DaoSession mDaoSession;
    //    private static MyAppliction sMyApplictions;
//
//    public MyAppliction() {
//        sMyApplictions=this;
//    }
//
//    public static MyAppliction getMyAppliction() {
//        return sMyApplictions;
//    }
    /* private static DaoSession mDaoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        initData();
    }

    private void initData() {
        final DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this, "aa.db");
        final DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDb());
        mDaoSession = daoMaster.newSession();
    }

    public static DaoSession getDaoSession(){
        return mDaoSession;
    }*/

    @Override
    public void onCreate() {
        super.onCreate();
        initData();
    }

    private void initData() {
        final DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this, "aa.db");
        final DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDb());
        mDaoSession = daoMaster.newSession();
    }

    public static DaoSession getDaoSession(){
        return mDaoSession;
    }
}
