package com.example.shappingb.utils;

import android.util.Log;

import com.example.shappingb.MyAppliction;
import com.example.shappingb.beans.DatasBean;
import com.example.shappingb.db.DaoMaster;
import com.example.shappingb.db.DaoSession;
import com.example.shappingb.db.DatasBeanDao;

import org.greenrobot.greendao.DbUtils;

import java.util.List;

/**
 * Created by 张亚丹 on 2019/6/21.
 */

public class DbUtild {

    private static final String TAG = "DbUtild";

    public static void insert(DatasBean datasBean){
        final DaoSession daoSession = MyAppliction.getDaoSession();
        if (qurryone(datasBean) == null) {
            daoSession.insertOrReplace(datasBean);
        }else {
            Log.i(TAG, "insert: 已存在");
        }
    }

    public static void delete(DatasBean datasBean){
        final DaoSession daoSession = MyAppliction.getDaoSession();
        if (qurryone(datasBean) != null){
            daoSession.delete(datasBean);
        }else {
            Log.i(TAG, "delete: "+daoSession);
        }
    }


    public static List<DatasBean> qurryAll(){
        final DaoSession daoSession = MyAppliction.getDaoSession();
        return daoSession.loadAll(DatasBean.class);
    }

    public static DatasBean qurry(DatasBean datasBean){
        final DaoSession daoSession = MyAppliction.getDaoSession();
        return daoSession.queryBuilder(DatasBean.class)
                .where(DatasBeanDao.Properties.Title.eq(datasBean.getTitle()))
                .build().unique();
    }
    public static DatasBean qurryone(DatasBean datasBean){
        final DaoSession daoSession = MyAppliction.getDaoSession();
        return daoSession.queryBuilder(DatasBean.class)
                .where(DatasBeanDao.Properties.Title.eq(datasBean.getTitle()))
                .build()
                .unique();
    }
//    public static DatasBean qurryone(DatasBean datasBean){
//        final DaoSession daoSession = MyAppliction.getDaoSession();
//        return daoSession.queryBuilder(DatasBean.class)
//                .where(DatasBeanDao.Properties.Title.eq(datasBean.getTitle()))
//                .build()
//                .unique();
//    }
}
