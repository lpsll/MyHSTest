package com.example.administrator.test.home.fragment;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.example.administrator.test.AppConfig;
import com.example.administrator.test.AppContext;
import com.example.administrator.test.MainActivity;
import com.example.administrator.test.R;
import com.example.administrator.test.common.base.BaseFragment;
import com.example.administrator.test.common.bean.ViewFlowBean;
import com.example.administrator.test.common.dto.BaseDTO;
import com.example.administrator.test.common.http.CallBack;
import com.example.administrator.test.common.http.CommonApiClient;
import com.example.administrator.test.common.utils.DialogUtils;
import com.example.administrator.test.common.utils.ImageLoaderUtils;
import com.example.administrator.test.common.utils.LogUtils;
import com.example.administrator.test.common.utils.TimeUtils;
import com.example.administrator.test.common.widget.ViewFlowLayout;
import com.example.administrator.test.home.HomeUiGoto;
import com.example.administrator.test.home.entity.AddAddressResult;
import com.example.administrator.test.home.entity.CarouselEntity;
import com.example.administrator.test.home.entity.CarouselResult;
import com.example.administrator.test.home.entity.FullServiceEntity;
import com.example.administrator.test.home.entity.FullServiceResult;
import com.example.administrator.test.home.entity.ServiceClasses;
import com.example.administrator.test.home.entity.ServiceData;
import com.example.administrator.test.home.entity.ServiceResult;
import com.example.administrator.test.home.entity.WhetherEvent;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;
import de.greenrobot.event.EventBus;


/**
 * 首页Fragment
 */
public class HomeFragment extends BaseFragment {

    @Bind(R.id.vf_layout)
    ViewFlowLayout mVfLayout;
    @Bind(R.id.middle_image1)
    ImageView mMiddleImage1;
    @Bind(R.id.tv01)
    TextView mTv01;
    @Bind(R.id.lin01)
    LinearLayout mLin01;
    @Bind(R.id.middle_image2)
    ImageView mMiddleImage2;
    @Bind(R.id.tv02)
    TextView mTv02;
    @Bind(R.id.lin02)
    LinearLayout mLin02;
    @Bind(R.id.middle_image3)
    ImageView mMiddleImage3;
    @Bind(R.id.tv03)
    TextView mTv03;
    @Bind(R.id.lin03)
    LinearLayout mLin03;
    @Bind(R.id.middle_image4)
    ImageView mMiddleImage4;
    @Bind(R.id.tv04)
    TextView mTv04;
    @Bind(R.id.lin04)
    LinearLayout mLin04;
    @Bind(R.id.middle_image5)
    ImageView mMiddleImage5;
    @Bind(R.id.tv05)
    TextView mTv05;
    @Bind(R.id.lin05)
    LinearLayout mLin05;
    @Bind(R.id.layout_middle1)
    LinearLayout mLayoutMiddle1;
    @Bind(R.id.image_ad)
    ImageView mImageAd;
    @Bind(R.id.rl_tv01)
    TextView mRlTv01;
    @Bind(R.id.lin06)
    LinearLayout mLin06;
    @Bind(R.id.lin07)
    LinearLayout mLin07;
    @Bind(R.id.lin08)
    LinearLayout mLin08;
    @Bind(R.id.lin09)
    LinearLayout mLin09;
    @Bind(R.id.rl_tv02)
    TextView mRlTv02;
    @Bind(R.id.lin10)
    LinearLayout mLin10;
    @Bind(R.id.lin11)
    LinearLayout mLin11;
    @Bind(R.id.lin12)
    LinearLayout mLin12;
    @Bind(R.id.lin13)
    LinearLayout mLin13;
    @Bind(R.id.rl_tv03)
    TextView mRlTv03;
    @Bind(R.id.lin14)
    LinearLayout mLin14;
    @Bind(R.id.lin15)
    LinearLayout mLin15;
    @Bind(R.id.lin_15)
    LinearLayout mLin115;
    @Bind(R.id.lin16)
    LinearLayout mLin16;
    @Bind(R.id.lin17)
    LinearLayout mLin17;
    @Bind(R.id.all_service)
    TextView mAllService;

    List<CarouselEntity> mCarouse;
    @Bind(R.id.service_img01_01)
    ImageView serviceImg0101;
    @Bind(R.id.service_tv01_01)
    TextView serviceTv0101;
    @Bind(R.id.service_img01_02)
    ImageView serviceImg0102;
    @Bind(R.id.service_tv01_02)
    TextView serviceTv0102;
    @Bind(R.id.service_img01_03)
    ImageView serviceImg0103;
    @Bind(R.id.service_tv01_03)
    TextView serviceTv0103;
    @Bind(R.id.service_img02_01)
    ImageView serviceImg0201;
    @Bind(R.id.service_tv02_01)
    TextView serviceTv0201;
    @Bind(R.id.service_img02_02)
    ImageView serviceImg0202;
    @Bind(R.id.service_tv02_02)
    TextView serviceTv0202;
    @Bind(R.id.service_img02_03)
    ImageView serviceImg0203;
    @Bind(R.id.service_tv02_03)
    TextView serviceTv0203;
    @Bind(R.id.service_img03_01)
    ImageView serviceImg0301;
    @Bind(R.id.service_tv03_01)
    TextView serviceTv0301;
    @Bind(R.id.service_img03_02)
    ImageView serviceImg0302;
    @Bind(R.id.service_tv03_02)
    TextView serviceTv0302;
    @Bind(R.id.service_img03_03)
    ImageView serviceImg0303;
    @Bind(R.id.service_tv03_03)
    TextView serviceTv0303;
    @Bind(R.id.service_tv01)
    TextView serviceTv01;
    @Bind(R.id.service_tv02)
    TextView serviceTv02;
    @Bind(R.id.service_tv03)
    TextView serviceTv03;
    @Bind(R.id.service_img03_04)
    ImageView serviceImg0304;
    @Bind(R.id.service_tv03_04)
    TextView serviceTv0304;
    List<ServiceClasses> classes;
    private String mName,mId;
    boolean login;
    List<FullServiceEntity> fsEntity;


    @Override
    protected void retry() {

    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_home;
    }

    @Override
    public void initView(View view) {
        mVfLayout.setOnItemClickListener(new ViewFlowLayout.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
            }
        });

    }


    @Override
    public void initData() {
//        reqCarousel();//轮播图
//        reqFullService();//全部服务类别类别
//        reqService();//制定服务类
//        if(AppContext.get("IS_LOGIN", false)){
//            reqWhether();//是否有未读消息
//        }

    }

    private void reqWhether() {
        BaseDTO dto = new BaseDTO();
        long time = TimeUtils.getSignTime();
        final String random = TimeUtils.genNonceStr();
        dto.setAccessToken(AppContext.get("accessToken", ""));
        dto.setUid(AppContext.get("uid", ""));
        dto.setSign(AppContext.get("uid", "")+time+random);
        dto.setRandom(random);
        dto.setTimestamp(time);
        CommonApiClient.whether(getActivity(), dto, new CallBack<AddAddressResult>() {
            @Override
            public void onSuccess(AddAddressResult result) {
                if (AppConfig.SUCCESS.equals(result.getCode())) {
                    LogUtils.e("是否有未读成功");

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

    private void reqService() {
        BaseDTO dto = new BaseDTO();
        CommonApiClient.service(getActivity(), dto, new CallBack<ServiceResult>() {
            @Override
            public void onSuccess(ServiceResult result) {
                if (AppConfig.SUCCESS.equals(result.getCode())) {
                    LogUtils.e("制定服务类成功");
                    if (result.getData() != null) {
                        setServiceData(result.getData());
                    }

                }

            }
        });
    }

    private void setServiceData(ServiceData data) {
        classes = data.getClasses();
        serviceTv01.setText(classes.get(0).getName());
        serviceTv02.setText(classes.get(1).getName());
        serviceTv03.setText(classes.get(2).getName());

        serviceTv0101.setText(classes.get(0).getServices().get(0).getName());
        ImageLoaderUtils.displayImage(classes.get(0).getServices().get(0).getLogo(), serviceImg0101);
        serviceTv0102.setText(classes.get(0).getServices().get(1).getName());
        ImageLoaderUtils.displayImage(classes.get(0).getServices().get(1).getLogo(), serviceImg0102);
        serviceTv0103.setText(classes.get(0).getServices().get(2).getName());
        ImageLoaderUtils.displayImage(classes.get(0).getServices().get(2).getLogo(), serviceImg0103);

        serviceTv0201.setText(classes.get(1).getServices().get(0).getName());
        ImageLoaderUtils.displayImage(classes.get(1).getServices().get(0).getLogo(), serviceImg0201);
        serviceTv0202.setText(classes.get(1).getServices().get(1).getName());
        ImageLoaderUtils.displayImage(classes.get(1).getServices().get(1).getLogo(), serviceImg0202);
        serviceTv0203.setText(classes.get(1).getServices().get(2).getName());
        ImageLoaderUtils.displayImage(classes.get(1).getServices().get(2).getLogo(), serviceImg0203);

        serviceTv0301.setText(classes.get(2).getServices().get(0).getName());
        ImageLoaderUtils.displayImage(classes.get(2).getServices().get(0).getLogo(), serviceImg0301);
        serviceTv0302.setText(classes.get(2).getServices().get(1).getName());
        ImageLoaderUtils.displayImage(classes.get(2).getServices().get(1).getLogo(), serviceImg0302);
        serviceTv0303.setText(classes.get(2).getServices().get(2).getName());
        ImageLoaderUtils.displayImage(classes.get(2).getServices().get(2).getLogo(), serviceImg0303);
        serviceTv0304.setText(classes.get(2).getServices().get(3).getName());
        ImageLoaderUtils.displayImage(classes.get(2).getServices().get(3).getLogo(), serviceImg0304);
    }

    private void reqFullService() {
        BaseDTO dto = new BaseDTO();
        CommonApiClient.fullService(getActivity(), dto, new CallBack<FullServiceResult>() {
            @Override
            public void onSuccess(FullServiceResult result) {
                if (AppConfig.SUCCESS.equals(result.getCode())) {
                    LogUtils.e("全部服务类别列表成功");
                    if (result.getData() != null) {
                        setResult(result.getData());
                    }

                }

            }
        });
    }

    private void setResult(List<FullServiceEntity> data) {
        fsEntity = data;
        mTv01.setText(data.get(0).getName());
        mTv02.setText(data.get(1).getName());
        mTv03.setText(data.get(2).getName());
        mTv04.setText(data.get(3).getName());
        mTv05.setText(data.get(4).getName());
        ImageLoaderUtils.displayImage(data.get(0).getLogo(), mMiddleImage1);
        ImageLoaderUtils.displayImage(data.get(1).getLogo(), mMiddleImage2);
        ImageLoaderUtils.displayImage(data.get(2).getLogo(), mMiddleImage3);
        ImageLoaderUtils.displayImage(data.get(3).getLogo(), mMiddleImage4);
        ImageLoaderUtils.displayImage(data.get(4).getLogo(), mMiddleImage5);
    }

    private void reqCarousel() {
        BaseDTO dto = new BaseDTO();
        CommonApiClient.carousel(getActivity(), dto, new CallBack<CarouselResult>() {
            @Override
            public void onSuccess(CarouselResult result) {
                if (AppConfig.SUCCESS.equals(result.getCode())) {
                    LogUtils.e("轮播图成功");
                    mCarouse = result.getData();
                    if (mCarouse != null && mCarouse.size() != 0) {
//                        ArrayList<ViewFlowBean> list = new ArrayList<>();
//                        for (int i = 0; i < mCarouse.size(); i++) {
//                            ViewFlowBean bean = new ViewFlowBean();
//                            if(TextUtils.isEmpty(mCarouse.get(i).getBannerimg())||null==mCarouse.get(i).getBannerimg()){
//
//                            }else {
//                                bean.setImgUrl(AppConfig.BASE_IMG_URL + mCarouse.get(i).getBannerimg());
//                                list.add(bean);
//                            }
//
//
//                        }
//                        mVfLayout.updateView(list);
                    }

                }

            }
        });
    }


    @OnClick({R.id.lin01,R.id.image_ad, R.id.lin02, R.id.lin03, R.id.lin04, R.id.lin05, R.id.lin06, R.id.lin07, R.id.lin08, R.id.lin09, R.id.lin10, R.id.lin11, R.id.lin12, R.id.lin13, R.id.lin14, R.id.lin15, R.id.lin_15, R.id.lin16, R.id.lin17, R.id.all_service})
    public void onClick(View view) {
        switch (view.getId()) {

        }
    }


}
