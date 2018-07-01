package com.example.administrator.test.common.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.widget.ImageView;

import com.example.administrator.test.AppConfig;
import com.example.administrator.test.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

/**
 * Created by lenovo on 2016/12/25.
 */
public class ImageLoaderUtils {
    /**
     * 获取默认图片方法
     *
     * @param imageUrl  图片URL
     * @param imageView 显示图片控件View
     */
    public static void displayImage(String imageUrl, ImageView imageView) {
        if(imageUrl!=null&&!imageUrl.contains("http://")){
            imageUrl= ((AppConfig.BASE_IMG_URL).trim()+imageUrl.trim()).trim();
        }
        ImageLoader.getInstance().displayImage(imageUrl,
                imageView, getDefaultOptions());
    }

    /**
     * 默认图片加载
     */
    public static DisplayImageOptions getDefaultOptions() {
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .resetViewBeforeLoading(true)
                .cacheInMemory(true)
                .cacheOnDisk(true).considerExifParams(true)
                .bitmapConfig(Bitmap.Config.ARGB_8888).build();
        return options;
    }

    /**
     * 获取圆形图片方法
     *
     * @param imageUrl  图片URL
     * @param imageView 显示图片控件View
     */
    public static void displayAvatarImage(String imageUrl, ImageView imageView) {
        if(imageUrl!=null&&!imageUrl.contains("http://")){
            imageUrl= ((AppConfig.BASE_URL).trim()+imageUrl.trim()).trim();
        }
        ImageLoader.getInstance().displayImage(imageUrl,
                imageView, getAvatarOptions());
    }

    /**
     * 获取圆形头像
     */
    public static DisplayImageOptions getAvatarOptions() {
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .resetViewBeforeLoading(true).cacheInMemory(true)
                .showImageForEmptyUri(R.drawable.page_icon_empty)
                .showImageOnFail(R.drawable.page_icon_empty)
                .cacheOnDisk(true).displayer(new RoundedBitmapDisplayer(200))
                .considerExifParams(true).bitmapConfig(Bitmap.Config.RGB_565)
                .build();
        return options;
    }



}
