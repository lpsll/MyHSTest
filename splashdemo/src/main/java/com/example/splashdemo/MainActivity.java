package com.example.splashdemo;

import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.splashdemo.home.HomeFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    public static final int TAB_NUM = 4;
    public static final String TAG= "tag";
    private ImageView[] mTabViews = new ImageView[TAB_NUM];
    private FragmentManager fragmentManager;
    private List<Fragment> fragmentList = new ArrayList<>();
    /**
     * Tab图片没有选中的状态资源ID
     */
    private int[] mTabIconNors = {
            R.drawable.shouyexdpi_03,
            R.drawable.dingdanxdpi_03,
            R.drawable.huodongxdpi_03,
            R.drawable.wodexdpi_03};
    /**
     * Tab图片选中的状态资源ID
     */
    private int[] mTabIconSels = {
            R.drawable.shouyedxdpi_03,
            R.drawable.dingdandxdpi_03,
            R.drawable.huodongdxdpi_03_03,
            R.drawable.wodedxdpi_03};

    private int currentTab = -1; // 当前Tab页面索引
    private ImageView mTvTabHome,mTvTabOrder,mTvTabCampaign,mTvTabMine;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mTvTabHome = (ImageView) findViewById(R.id.tv_tab_home);
        mTvTabOrder = (ImageView) findViewById(R.id.tv_tab_order);
        mTvTabCampaign = (ImageView) findViewById(R.id.tv_tab_campaign);
        mTvTabMine = (ImageView) findViewById(R.id.tv_tab_mine);
        fragmentManager = getSupportFragmentManager();
        mTabViews[0] = mTvTabHome;
        mTabViews[1] = mTvTabOrder;
        mTabViews[2] = mTvTabCampaign;
        mTabViews[3] = mTvTabMine;

        for (int i = 0; i < mTabViews.length; i++) {
            fragmentList.add(null);
            final int j = i;
            mTabViews[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showTab(j);
                }
            });
        }
        showTab(0); // 显示目标tab
    }

    /**
     * 切换tab
     *
     * @param idx
     */
    private void showTab(int idx) {
        Log.e(TAG,"idx---"+idx);
        Fragment targetFragment = (Fragment) fragmentManager
                .findFragmentByTag("tag" + idx);
        Log.e(TAG,"targetFragment---"+targetFragment);

        if (targetFragment == null || !targetFragment.isAdded()) {
            if (idx < fragmentList.size() && fragmentList.get(idx) != null) {
                targetFragment = fragmentList.get(idx);
                Log.e(TAG,"targetFragment---if---"+targetFragment);
            } else {
                targetFragment = addFragment(idx);
                Log.e(TAG,"targetFragment---else---"+targetFragment);
            }
        }
        hideAllFragments(targetFragment);
        showFragment(targetFragment);
        for (int i = 0; i < TAB_NUM; i++) {
            if (idx == i) {
                mTabViews[i].setBackgroundColor(getResources().getColor(R.color.navi_press));

            } else {
                mTabViews[i].setBackgroundColor(getResources().getColor(R.color.navi));

            }
        }
        currentTab = idx; // 更新目标tab为当前tab
        switch (currentTab) {
            case 0:
                Toast.makeText(MainActivity.this,"this is one Fragment",Toast.LENGTH_SHORT).show();

                break;
            case 1:
                Toast.makeText(MainActivity.this,"this is two Fragment",Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(MainActivity.this,"this is three Fragment",Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Toast.makeText(MainActivity.this,"this is four Fragment",Toast.LENGTH_SHORT).show();
                break;

        }
    }

    /**
     * @param fragment 除了fragment，其他的都hide
     */
    private void hideAllFragments(Fragment fragment) {
        Log.e(TAG,"hideAllFragments---fragment---"+fragment);
        for (int i = 0; i < TAB_NUM; i++) {
            Fragment f = fragmentManager.findFragmentByTag("tag" + i);
            Log.e(TAG,"f-----"+f);
            if (f != null && f.isAdded() && f != fragment) {
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.hide(f);
                transaction.commitAllowingStateLoss();
                f.setUserVisibleHint(false);
            }
        }
    }

    private void showFragment(Fragment fragment) {
        Log.e(TAG,"showFragment---fragment---"+fragment);
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.show(fragment);
        transaction.commitAllowingStateLoss();
        fragment.setUserVisibleHint(true);
    }

    private Fragment addFragment(int index) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        Fragment fragment = null;
        switch (index) {
            case 0:
                fragment = new HomeFragment();
                break;
            case 1:
                fragment = new HomeFragment();
                break;
            case 2:
                fragment = new HomeFragment();
                break;
            case 3:
                fragment = new HomeFragment();
                break;

        }
        Log.e(TAG,"fragment---"+fragment);
        fragmentList.add(index, fragment);
        Log.e(TAG, "fragmentList---" + fragmentList);
        transaction.add(R.id.realtabcontent, fragment, "tag" + index);
        transaction.commitAllowingStateLoss();
        return fragment;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn:

        }
    }
}
