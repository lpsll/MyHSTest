package com.example.administrator.test.Order.fragment;

import android.content.DialogInterface;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.View;

import com.example.administrator.test.Order.adapter.OrderTabListAdapter;
import com.example.administrator.test.Order.entity.OrderEvent;
import com.example.administrator.test.R;
import com.example.administrator.test.common.AppContext;
import com.example.administrator.test.common.base.BaseFragment;
import com.example.administrator.test.common.utils.DialogUtils;
import com.example.administrator.test.common.utils.LogUtils;
import com.example.administrator.test.common.widget.SlidingTabLayout;
import com.example.administrator.test.home.HomeUiGoto;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by Administrator on 2016/12/23.
 */
public class OrderFragment extends BaseFragment {
    public static final int TAB_A = 1;
    public static final int TAB_B = 2;
    public static final int TAB_C = 3;
    public static final int TAB_D = 4;
    public static final int TAB_E = 5;
    @Bind(R.id.order_tab)
    SlidingTabLayout mOrderTab;
    @Bind(R.id.order_content)
    ViewPager mOrderContent;
    private OrderTabListAdapter mAdapter;
    private List<Fragment> fragmentList;
    boolean login,tlt;
    String[] titles;
    private String tl;

    @Override
    protected void retry() {

    }

    @Override
    protected int getLayoutResId() {

        return R.layout.fragment_order;
    }


    //定义一个接口
    public interface OnOKClickListener  {
        public void onOKClick();
    }

    @Override
    public void initView(View view) {
        mOrderTab.setVisibility(View.GONE);
        AppContext.set("inFlag", true);
        OrderInsideFragment insideFragmentA = OrderInsideFragment.newInstance(TAB_A);
        OrderInsideFragment insideFragmentB = OrderInsideFragment.newInstance(TAB_B);
        OrderInsideFragment insideFragmentC = OrderInsideFragment.newInstance(TAB_C);
        OrderInsideFragment insideFragmentD = OrderInsideFragment.newInstance(TAB_D);
        OrderInsideFragment insideFragmentE = OrderInsideFragment.newInstance(TAB_E);
        fragmentList = new ArrayList<Fragment>();
        fragmentList.add(insideFragmentA);
        fragmentList.add(insideFragmentB);
        fragmentList.add(insideFragmentC);
        fragmentList.add(insideFragmentD);
        fragmentList.add(insideFragmentE);
        bindAdapter();


    }

    private void bindAdapter() {
        titles= getResources().getStringArray(R.array.order_tab_false);
        mAdapter = new OrderTabListAdapter(getChildFragmentManager(), this, titles, fragmentList);
        mOrderContent.setAdapter(mAdapter);
        mOrderContent.setOffscreenPageLimit(fragmentList.size());
        mOrderTab.setSelectedIndicatorColors(getResources().getColor(R.color.navi));
        mOrderTab.setDistributeEvenly(true);
        mOrderTab.setViewPager(mOrderContent);
        login = AppContext.get("IS_LOGIN",false);
        if(login){
        }else {
            DialogUtils.confirm(getActivity(), "您尚未登录，是否去登录？", listener);

        }
    }

    DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            HomeUiGoto.gotoLogin(getActivity());
        }
    };

    @Override
    public void initData() {
    }


}
