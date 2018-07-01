package com.example.administrator.test.mine.fragment;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.test.AppConfig;
import com.example.administrator.test.R;
import com.example.administrator.test.common.AppContext;
import com.example.administrator.test.common.base.BaseFragment;
import com.example.administrator.test.common.dto.BaseDTO;
import com.example.administrator.test.common.http.CallBack;
import com.example.administrator.test.common.http.CommonApiClient;
import com.example.administrator.test.common.utils.DialogUtils;
import com.example.administrator.test.common.utils.LogUtils;
import com.example.administrator.test.common.utils.TimeUtils;
import com.example.administrator.test.home.HomeUiGoto;
import com.example.administrator.test.mine.MineUiGoto;
import com.example.administrator.test.mine.entity.UserDetailResult;

import java.util.HashMap;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.internal.platform.Platform;

/**
 * Created by Administrator on 2016/12/23.
 */
public class MineFragment extends BaseFragment {
    @Bind(R.id.rl_mine_changephone)
    RelativeLayout rlMineChangephone;
    @Bind(R.id.ll_mine_chongzhi)
    LinearLayout llMineChongzhi;
    @Bind(R.id.ll_mine_more_setting)
    LinearLayout llMineMoreSetting;
    @Bind(R.id.ll_mine_address)
    LinearLayout llMineAddress;
    @Bind(R.id.ll_mine_myorder)
    LinearLayout llMineMyorder;
    @Bind(R.id.ll_mine_coupon)
    LinearLayout llMineCoupon;
    @Bind(R.id.ll_mine_feedback)
    LinearLayout llMineFeedback;
    @Bind(R.id.tv_mine_phone)
    TextView tvMinePhone;
    @Bind(R.id.tv_mine_point)
    TextView tvMinePoint;
    @Bind(R.id.tv_mine_balance)
    TextView tvMineBalance;
    @Bind(R.id.ll_mine_share)
    LinearLayout llMineShare;
    PopupWindow popWindow;
    @Bind(R.id.rl_my_score)
    RelativeLayout rlMyScore;
    private LinearLayout weixin, friend, weibo, qq, qqZon;
    private TextView text;
    private String type;


    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_mine;
    }


    @Override
    public void initView(View view) {
        if (AppContext.get("IS_LOGIN", false)) {
            //登录状态时就设置为用户手机号
            tvMinePhone.setText(AppContext.get("uid", ""));
            tvMinePoint.setVisibility(View.VISIBLE);
            tvMineBalance.setVisibility(View.VISIBLE);
            getUserDetail();

        } else {
            tvMinePhone.setText("请登录");
            tvMinePoint.setVisibility(View.GONE);
            tvMineBalance.setVisibility(View.GONE);

        }

    }

    /**
     * 获取用户信息
     * 用户详细信息请求接口
     * <p/>
     * accessToken:访问授权码
     * <p/>
     * uid:用户ID，默认为手机号码
     * <p/>
     * timestamp:当前时间戳
     * <p/>
     * random:随机数
     * <p/>
     * sign:签名【生成规则uid+timestamp+random 后md5加密串】
     */
    private void getUserDetail() {

        long time = TimeUtils.getSignTime();
        String random = TimeUtils.genNonceStr();

        BaseDTO baseDTO = new BaseDTO();
        baseDTO.setAccessToken(AppContext.get("accessToken", ""));
        baseDTO.setUid(AppContext.get("uid", ""));
        baseDTO.setTimestamp(time);
        baseDTO.setRandom(random);
        baseDTO.setSign(AppContext.get("uid", "") + time + random);

        CommonApiClient.getUserDetail(getActivity(), baseDTO, new CallBack<UserDetailResult>() {
            @Override
            public void onSuccess(UserDetailResult result) {
                LogUtils.e("获取用户信息========" + result.getMsg());
                if (AppConfig.SUCCESS.equals(result.getCode())) {
                    double points = result.getData().getPoints();
                    double balance = result.getData().getBalance();
                    tvMinePoint.setText(points + "分");
                    tvMineBalance.setText(balance + "元");
                    AppContext.set("balance", String.valueOf(balance));

                }
                if (null != result.getMsg() && result.getMsg().equals("无效token")) {
                    AppContext.set("IS_LOGIN", false);
                    AppContext.set("msg_tk", "1");
                    tvMinePhone.setText("请登录");
                    tvMinePoint.setVisibility(View.GONE);
                    tvMineBalance.setVisibility(View.GONE);
                    DialogUtils.confirm(getActivity(), "请重新登录", mListener);
                }
            }
        });


    }

    DialogInterface.OnClickListener mListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            HomeUiGoto.gotoLoginForPwd(getActivity());
            dialog.cancel();
        }


    };

    @Override
    public void initData() {

    }


    @Override
    protected void retry() {

    }


    @OnClick({R.id.rl_my_score, R.id.ll_about_juran, R.id.rl_mine_changephone, R.id.ll_mine_chongzhi, R.id.ll_mine_more_setting, R.id.ll_mine_share, R.id.ll_mine_myorder, R.id.ll_mine_address, R.id.ll_mine_coupon, R.id.ll_mine_more_phone, R.id.ll_mine_feedback})
    public void onClick(View view) {
        switch (view.getId()) {

        }
    }

}
