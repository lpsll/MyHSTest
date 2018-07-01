package com.example.administrator.test.Order.fragment;

import android.content.DialogInterface;
import android.os.Bundle;

import com.example.administrator.test.AppConfig;
import com.example.administrator.test.Order.adapter.OrderInsideAdapter;
import com.example.administrator.test.Order.dto.OrderDTO;
import com.example.administrator.test.Order.entity.OrderEntity;
import com.example.administrator.test.Order.entity.OrderEvent;
import com.example.administrator.test.Order.entity.OrderResult;
import com.example.administrator.test.R;
import com.example.administrator.test.common.AppContext;
import com.example.administrator.test.common.base.BaseListFragment;
import com.example.administrator.test.common.http.CallBack;
import com.example.administrator.test.common.http.CommonApiClient;
import com.example.administrator.test.common.utils.DialogUtils;
import com.example.administrator.test.common.utils.LogUtils;
import com.example.administrator.test.common.utils.TimeUtils;
import com.example.administrator.test.home.HomeUiGoto;
import com.qluxstory.ptrrecyclerview.BaseRecyclerAdapter;

import java.io.Serializable;
import java.util.List;

import de.greenrobot.event.EventBus;

/**
 * Created by lenovo on 2016/12/25.
 */
public class OrderInsideFragment extends BaseListFragment<OrderEntity> {
    private static final String TYPE = "type";
    private int type;
    boolean login;
    OrderFragment.OnOKClickListener onOKClickListener;
    boolean flag;

    public static OrderInsideFragment newInstance(int type) {
        OrderInsideFragment fragment = new OrderInsideFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(TYPE, type);//传递Type
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            type = bundle.getInt(TYPE, OrderFragment.TAB_A);

        }
        login = AppContext.get("IS_LOGIN", false);
    }

    @Override
    public BaseRecyclerAdapter<OrderEntity> createAdapter() {
        return new OrderInsideAdapter(getActivity(),type);
    }

    @Override
    protected String getCacheKeyPrefix() {
        return "OrderInsideFragment"+type+"_";
    }

    @Override
    public List<OrderEntity> readList(Serializable seri) {
        return ((OrderResult)seri).getData().getData();
    }

    @Override
    protected void sendRequestData() {
        flag = AppContext.get("inFlag",false);
        if(login){
            OrderDTO dto = new OrderDTO();
            final long time = TimeUtils.getSignTime();
            String random = TimeUtils.genNonceStr();
            dto.setAccessToken(AppContext.get("accessToken",""));
            dto.setRandom(random);
            dto.setUid(AppContext.get("uid",""));
            dto.setTimestamp(time);
            dto.setSign(AppContext.get("uid","")+time+random);
            dto.setPage(String.valueOf(mCurrentPage));
            dto.setSize(String.valueOf(PAGE_SIZE));
            LogUtils.e("type----",""+type);
            if(type ==1){
                CommonApiClient.unfinished(getActivity(), dto, new CallBack<OrderResult>() {
                    @Override
                    public void onSuccess(OrderResult result) {
                        if (AppConfig.SUCCESS.equals(result.getCode())) {
                            LogUtils.e("未完成订单成功");
                            mErrorLayout.setErrorMessage("暂无订单记录", mErrorLayout.FLAG_NODATA);
                            mErrorLayout.setErrorImag(R.drawable.siaieless1, mErrorLayout.FLAG_NODATA);
                            requestDataSuccess(result);
                            setDataResult(result.getData().getData());
                            if (result.getData().getTotal().equals("0")) {
                                AppContext.set("TypeOne", false);
                            } else {
                                AppContext.set("TypeOne", true);
                            }
                        }

                    }
                });
            }
            else if(type ==2){
                CommonApiClient.tobePaid(getActivity(), dto, new CallBack<OrderResult>() {
                    @Override
                    public void onSuccess(OrderResult result) {
                        if (AppConfig.SUCCESS.equals(result.getCode())) {
                            LogUtils.e("待支付订单成功");
                            mErrorLayout.setErrorMessage("暂无订单记录",mErrorLayout.FLAG_NODATA);
                            mErrorLayout.setErrorImag(R.drawable.siaieless1,mErrorLayout.FLAG_NODATA);
                            requestDataSuccess(result);
                            setDataResult(result.getData().getData());
                        }

                    }
                });
            }
            else if(type ==3){
                CommonApiClient.tobeEvaluated(getActivity(), dto, new CallBack<OrderResult>() {
                    @Override
                    public void onSuccess(OrderResult result) {
                        if (AppConfig.SUCCESS.equals(result.getCode())) {
                            LogUtils.e("待评价订单成功");
                            mErrorLayout.setErrorMessage("暂无订单记录",mErrorLayout.FLAG_NODATA);
                            mErrorLayout.setErrorImag(R.drawable.siaieless1,mErrorLayout.FLAG_NODATA);
                            requestDataSuccess(result);
                            setDataResult(result.getData().getData());
                        }

                    }
                });
            }
            else if(type ==4){
                CommonApiClient.completed(getActivity(), dto, new CallBack<OrderResult>() {
                    @Override
                    public void onSuccess(OrderResult result) {
                        if (AppConfig.SUCCESS.equals(result.getCode())) {
                            LogUtils.e("已完成订单成功");
                            mErrorLayout.setErrorMessage("暂无订单记录",mErrorLayout.FLAG_NODATA);
                            mErrorLayout.setErrorImag(R.drawable.siaieless1,mErrorLayout.FLAG_NODATA);
                            requestDataSuccess(result);
                            setDataResult(result.getData().getData());
                        }

                    }
                });
            }
            else if(type ==5){
                CommonApiClient.whole(getActivity(), dto, new CallBack<OrderResult>() {
                    @Override
                    public void onSuccess(OrderResult result) {
                        if (AppConfig.SUCCESS.equals(result.getCode())) {
                            LogUtils.e("全部订单成功");
                            mErrorLayout.setErrorMessage("暂无订单记录",mErrorLayout.FLAG_NODATA);
                            mErrorLayout.setErrorImag(R.drawable.siaieless1,mErrorLayout.FLAG_NODATA);
                            requestDataSuccess(result);
                            setDataResult(result.getData().getData());

                        }


                    }
                });
            }

        }

        else {
            DialogUtils.confirm(getActivity(), "您尚未登录，是否去登录？", listener);
        }



    }

    DialogInterface.OnClickListener mListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            dialog.cancel();
            HomeUiGoto.gotoLoginForPwd(getActivity());

        }


    };


    @Override
    public void initData() {

    }

    DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
        }
    };

    public boolean autoRefreshIn(){
        if(login){
            return true;
        }else {
            return false;
        }

    }
}
