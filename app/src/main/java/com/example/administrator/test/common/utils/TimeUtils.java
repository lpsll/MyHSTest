package com.example.administrator.test.common.utils;

import java.util.Random;

/**
 * Created by lenovo on 2016/12/25.
 */
public class TimeUtils {
    /**
     * 获取系统时间
     */
    public static long getSignTime(){
        long t =System.currentTimeMillis();
        return t;

    }

    /**
     * nonceStr随机数
     */
    public static String genNonceStr() {
        Random random = new Random();
        return String.valueOf(random.nextInt(10000));
    }

}
