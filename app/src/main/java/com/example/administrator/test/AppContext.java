package com.example.administrator.test;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.administrator.test.common.base.BaseApplication;

/**
 * Created by lenovo on 2016/12/25.
 */
public class AppContext extends BaseApplication {
    private static AppContext instance;
    private SharedPreferences.Editor editor;
    private SharedPreferences sp;
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



    /**
     * 获得当前app运行的AppContext
     *
     * @return
     */
    public static AppContext getInstance() {
        return instance;
    }
}
