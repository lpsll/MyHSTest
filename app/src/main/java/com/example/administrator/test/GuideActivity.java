package com.example.administrator.test;

import android.os.Handler;
import android.os.Message;
import android.view.WindowManager;

import com.example.administrator.test.common.base.BaseActivity;
import com.example.administrator.test.home.HomeUiGoto;

/**
 * Created by Administrator on 2016/12/23.
 */
public class GuideActivity extends BaseActivity {
    @Override
    protected int getLayoutResId() {
        return R.layout.activity_guide;
    }

    @Override
    public void initView() {
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

    }

    @Override
    public void initData() {
        new Thread(new ThreadShow()).start();
    }
    // handler类接收数据
    Handler tHandler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    HomeUiGoto.gotoSplash(GuideActivity.this);
                    finish();
                    break;
            }
        };
    };

    // 线程类
    class ThreadShow implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
                Message msg = new Message();
                msg.what = 1;
                tHandler.sendMessage(msg);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
