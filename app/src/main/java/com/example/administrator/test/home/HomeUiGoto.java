package com.example.administrator.test.home;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.administrator.test.MainActivity;
import com.example.administrator.test.SplashActivity;

/**
 * Created by Administrator on 2016/12/23.
 */
public class HomeUiGoto {
    public static void gotoMain(Context context){
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

    public static void gotoSplash(Context context){
        Intent intent = new Intent(context, SplashActivity.class);
        context.startActivity(intent);
    }

    /**
     * 从我的跳转到登录页(密码登录)
     * @param
     */
    public static final int LOFIN_REQUEST = 0x1100;
    public static void gotoLoginForPwd(Activity act) {

//        Intent intent = new Intent(act, LoginForPwdActivity.class);
//        act.startActivityForResult(intent, LOFIN_REQUEST);
    }

    /**
     * 跳转到分类页
     * @param context
     * @param bundle
     */

    public static void gotoCf(Context context, Bundle bundle){
//        Intent intent = new Intent(context, ClassificationActivity.class);
//        intent.putExtra("bundle",bundle);
//        context.startActivity(intent);
    }

    /**
     * 跳转到预约页
     * @param context
     * @param bundle
     */

    public static void gotoApt(Context context, Bundle bundle){
//        Intent intent = new Intent(context, AppointmentActivity.class);
//        intent.putExtra("bundle",bundle);
//        context.startActivity(intent);
    }

    /**
     * 从预约跳转到登录页(密码登录)
     * @param
     */
    public static final int LG_REQUEST = 0x3100;
    public static void gotoLogin(Activity act) {

//        Intent intent = new Intent(act, LoginForPwdActivity.class);
//        act.startActivityForResult(intent,LG_REQUEST);
    }

}
