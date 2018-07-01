package com.example.splashdemo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/12/26.
 */
public class SplashActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mBtn;
    int time = 5;
    private Handler readHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what==0){
                if(time>0){
                    mBtn.setText("倒计时"+time);
                    time--;
                    readHandler.sendEmptyMessageDelayed(0,1000);
                }else {
                    Toast.makeText(SplashActivity.this,"倒计时结束",Toast.LENGTH_SHORT).show();
//                    Intent intent = new Intent(SplashActivity.this,MainActivity.class);
//                    startActivity(intent);
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.MainActivity");
                    startActivity(intent);
                }


            }
        }
    };

    private ReadHandler mReadHandler =null;
    private class ReadHandler extends Handler{
        private  ReadListern listern;
        private int time;

        public ReadHandler(int time, ReadListern listern){
            this.time  = time;
            this.listern = listern;

        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Log.e("time---",""+time);
            switch (msg.what){
                case 1:
                    this.listern.GoMain(--time);
                    if(time>0){
                        mReadHandler.sendEmptyMessageDelayed(1,1000);
                    }
                    break;
            }

        }
    }
    private interface ReadListern{
        void GoMain(int time);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initView();
    }

    private void initView() {
        mBtn = (Button) findViewById(R.id.btn);
        mBtn.setOnClickListener(this);

        readHandler.sendEmptyMessageDelayed(0,1000);

//        mReadHandler = new ReadHandler(5, new ReadListern() {
//            @Override
//            public void GoMain(int time) {
//                Log.e("GoMain---time--",""+time);
//                if(time>0){
//                    mBtn.setText("倒计时"+time);
//                }else {
//                    Toast.makeText(SplashActivity.this,"倒计时结束",Toast.LENGTH_SHORT).show();
//                    Intent intent = new Intent(SplashActivity.this,MainActivity.class);
//                    startActivity(intent);
//                }
//            }
//        });
//        mReadHandler.sendEmptyMessageDelayed(1,1000);

    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn:
                Intent intent = new Intent(SplashActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }
}
