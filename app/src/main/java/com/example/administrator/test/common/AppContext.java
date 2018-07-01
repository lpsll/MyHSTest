package com.example.administrator.test.common;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.administrator.test.common.base.BaseApplication;
import com.example.administrator.test.common.cache.DiskLruCacheHelper;

/**
 * Created by Administrator on 2016/12/23.
 */
public class AppContext extends BaseApplication {

    private static AppContext instance;
    private SharedPreferences.Editor editor;
    private SharedPreferences sp;
    static DiskLruCacheHelper helper;
    /**
     * 清单文件名称
     */
    public static final String SP_NAME = "jrjz_app";

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        this.sp = this.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        this.editor = this.sp.edit();

    }

    public static synchronized DiskLruCacheHelper helper() {
        return helper;
    }

    /**
     * 获得当前app运行的AppContext
     *
     * @return
     */
    public static AppContext getInstance() {
        return instance;
    }

}