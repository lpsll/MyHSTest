package com.example.administrator.test.common.utils;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;

/**
 * 布局计算工具
 */
public class LayoutUtil {


    /**
     * 根据现有宽度获取屏幕适配的高
     */
    public static int getAdaptiveHeight(int curWidth,
                                        float oldHeight, float oldWidth) {
        int curHeight=0;
        float h=curWidth * oldHeight / oldWidth;
        if((curWidth * oldHeight) % oldWidth==0) {
            curHeight = (int)(h);
        }else{
            curHeight = (int)(h)+3;
        }
        return curHeight;
    }

    /**
     * 重新计算控件高度
     */
    public static void reMesureHeight(View v, int curWidth,
                                      float oldHeight, float oldWidth) {
        ViewGroup.LayoutParams layoutParam = v.getLayoutParams();
        layoutParam.height = LayoutUtil.getAdaptiveHeight(curWidth,
                oldHeight, oldWidth);
        v.setLayoutParams(layoutParam);
    }
}
