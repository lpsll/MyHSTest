package com.example.administrator.test;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.test.campaign.fragment.CampaignFragment;
import com.example.administrator.test.Order.fragment.OrderFragment;
import com.example.administrator.test.common.base.BaseFragment;
import com.example.administrator.test.common.base.BaseHomeTitleActivity;
import com.example.administrator.test.common.utils.ToastUtils;
import com.example.administrator.test.home.fragment.HomeFragment;
import com.example.administrator.test.mine.fragment.MineFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class MainActivity extends BaseHomeTitleActivity {

    @Bind(R.id.tv_tab_home)
    ImageView mTvTabHome;
    @Bind(R.id.tv_tab_order)
    ImageView mTvTabOrder;
    @Bind(R.id.tv_tab_campaign)
    ImageView mTvTabCampaign;
    @Bind(R.id.tv_tab_mine)
    ImageView mTvTabMine;
    int fg1,fg2,fg3,fg4,fg5;


    public static final int TAB_NUM = 4;
    private ImageView[] mTabViews = new ImageView[TAB_NUM];
    private FragmentManager fragmentManager;
    private List<BaseFragment> fragmentList = new ArrayList<>();
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
    private TextView mBaseEnsure, mBaseBack;

    @Override
    protected int getContentResId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        mBaseBack = (TextView) findViewById(R.id.base_titlebar_back);
        mBaseEnsure = (TextView) findViewById(R.id.base_titlebar_ensure);
        mBaseBack.setText("北京");

        fg1 = 0;
        fg2 = 0;
        fg3 = 0;
        fg4 = 0;
        fg5 = 0;

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
     * @param fragment 除了fragment，其他的都hide
     */
    private void hideAllFragments(BaseFragment fragment) {
        for (int i = 0; i < TAB_NUM; i++) {
            Fragment f = fragmentManager.findFragmentByTag("tag" + i);
            if (f != null && f.isAdded() && f != fragment) {
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.hide(f);
                transaction.commitAllowingStateLoss();
                f.setUserVisibleHint(false);
            }
        }
    }

    private BaseFragment addFragment(int index) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        BaseFragment fragment = null;
        switch (index) {
            case 0:
                fragment = new HomeFragment();
                break;
            case 1:
                fragment = new OrderFragment();
                break;
            case 2:
                fragment = new CampaignFragment();
                break;
            case 3:
                fragment = new MineFragment();
                break;

        }
        fragmentList.add(index, fragment);
        transaction.add(R.id.realtabcontent, fragment, "tag" + index);
        transaction.commitAllowingStateLoss();
        return fragment;
    }

    private void showFragment(BaseFragment fragment) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.show(fragment);
        transaction.commitAllowingStateLoss();
        fragment.setUserVisibleHint(true);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        if (intent != null) {
            if (intent.getExtras() != null) {
                int tag = intent.getExtras().getInt("tag");
                showTab(tag);
            }


        }
    }

    /**
     * 切换tab
     *
     * @param idx
     */
    private void showTab(int idx) {
        BaseFragment targetFragment = (BaseFragment) fragmentManager
                .findFragmentByTag("tag" + idx);

        if (targetFragment == null || !targetFragment.isAdded()) {
            if (idx < fragmentList.size() && fragmentList.get(idx) != null) {
                targetFragment = fragmentList.get(idx);
            } else {
                targetFragment = addFragment(idx);
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
        getTitleLayout().setVisibility(View.VISIBLE);
        switch (currentTab) {
            case 0:
                setTitleText("居然家政");
                mBaseBack.setVisibility(View.VISIBLE);
                mBaseEnsure.setVisibility(View.VISIBLE);
                if(fg1==0){
                    fg1=1;
                }else {
                    targetFragment.initData();
                }
                break;
            case 1:
                setTitleText("订单");
                mBaseBack.setVisibility(View.GONE);
                mBaseEnsure.setVisibility(View.GONE);
                if(fg2==0){
                    fg2=1;
                }else {
                    targetFragment.initView(null);
                }
                break;
            case 2:
                setTitleText("活动");
                mBaseBack.setVisibility(View.GONE);
                mBaseEnsure.setVisibility(View.GONE);
                if(fg3==0){
                    fg3=1;
                }else {
                    targetFragment.initData();
                }
                break;
            case 3:
                setTitleText("个人中心");
                mBaseBack.setVisibility(View.GONE);
                mBaseEnsure.setVisibility(View.GONE);
                if(fg4==0){
                    fg4=1;
                }else {
                    targetFragment.initView(null);
                }
                break;

        }
    }

    @Override
    public void initData() {
    }


    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.base_titlebar_ensure:
                break;
            default:
                break;
        }
    }

    /**
     * 连按两次返回退出应用
     */
    private long fistTime = 0;
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            if((System.currentTimeMillis() - fistTime)>2000){
                ToastUtils.showShort(this,"连按两次返回键退出应用");
                fistTime = System.currentTimeMillis();
                return true;
            }
        }
        return super.onKeyUp(keyCode, event);
    }

}
