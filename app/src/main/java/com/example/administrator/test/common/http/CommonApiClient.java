package com.example.administrator.test.common.http;

import android.app.Activity;

import com.example.administrator.test.campaign.entity.CampaignResult;
import com.example.administrator.test.Order.dto.OrderDTO;
import com.example.administrator.test.Order.entity.OrderResult;
import com.example.administrator.test.common.dto.BaseDTO;
import com.example.administrator.test.home.entity.AddAddressResult;
import com.example.administrator.test.home.entity.CarouselResult;
import com.example.administrator.test.home.entity.FullServiceResult;
import com.example.administrator.test.home.entity.ServiceResult;
import com.example.administrator.test.mine.entity.UserDetailResult;

/**
 * Created by lenovo on 2016/12/25.
 */
public class CommonApiClient extends BaseApiClient {
    /**
     * 是否有未读消息
     * @param act
     * @param dto
     * @param callback
     */
    public static void whether(Activity act, BaseDTO
            dto, CallBack<AddAddressResult> callback) {
        AsyncCallBack<AddAddressResult> asyncCallBack = new AsyncCallBack<>(
                act, callback, AddAddressResult.class);
        post(getAbsoluteUrl("/systemmessage/flagByUid"), dto,
                asyncCallBack);
    }

    /**
     * 制定服务类
     * @param act
     * @param dto
     * @param callback
     */
    public static void service(Activity act, BaseDTO
            dto, CallBack<ServiceResult> callback) {
        AsyncCallBack<ServiceResult> asyncCallBack = new AsyncCallBack<>(
                act, callback, ServiceResult.class);
        get(getAbsoluteUrl("/service/indexServices"), dto,
                asyncCallBack);
    }

    /**
     * 全部服务类别
     * @param act
     * @param dto
     * @param callback
     */
    public static void fullService(Activity act, BaseDTO
            dto, CallBack<FullServiceResult> callback) {
        AsyncCallBack<FullServiceResult> asyncCallBack = new AsyncCallBack<>(
                act, callback, FullServiceResult.class);
        get(getAbsoluteUrl("/service/allServiceClasses"), dto,
                asyncCallBack);
    }

    /**
     * 轮播图
     * @param act
     * @param dto
     * @param callback
     */
    public static void carousel(Activity act, BaseDTO
            dto, CallBack<CarouselResult> callback) {
        AsyncCallBack<CarouselResult> asyncCallBack = new AsyncCallBack<>(
                act, callback, CarouselResult.class);
        get(getAbsoluteUrl("/banner/bannerlist"), dto,
                asyncCallBack);
    }

    /**
     * 获取用户信息
     * @param act
     * @param dto
     * @param callback
     */
    public static void getUserDetail(Activity act, BaseDTO
            dto, CallBack<UserDetailResult> callback) {
        AsyncCallBack<UserDetailResult> asyncCallBack = new AsyncCallBack<>(
                act, callback, UserDetailResult.class);
        getNew(getAbsoluteUrl("/user/userDetail?"), dto,
                asyncCallBack);
    }

    /**活动页面数据
     *
     * @param act
     * @param dto
     * @param callback
     */
    public static void campaign(Activity act, BaseDTO
            dto, CallBack<CampaignResult> callback) {
        AsyncCallBack<CampaignResult> asyncCallBack = new AsyncCallBack<>(
                act, callback, CampaignResult.class);
        post(getAbsoluteUrl("/activity/activityList"), dto,
                asyncCallBack);
    }

    /**
     * 未完成订单
     * @param act
     * @param dto
     * @param callback
     */
    public static void unfinished (Activity act, OrderDTO
            dto, CallBack<OrderResult> callback) {
        AsyncCallBack<OrderResult> asyncCallBack = new AsyncCallBack<>(
                act, callback, OrderResult.class);
        post(getAbsoluteUrl("/custServiceOrder/unFinished"), dto,
                asyncCallBack);
    }

    /**
     * 待支付订单
     * @param act
     * @param dto
     * @param callback
     */
    public static void tobePaid(Activity act, OrderDTO
            dto, CallBack<OrderResult> callback) {
        AsyncCallBack<OrderResult> asyncCallBack = new AsyncCallBack<>(
                act, callback, OrderResult.class);
        post(getAbsoluteUrl("/custServiceOrder/waitPay"), dto,
                asyncCallBack);
    }
    /**
     * 待评价订单
     * @param act
     * @param dto
     * @param callback
     */
    public static void tobeEvaluated(Activity act, OrderDTO
            dto, CallBack<OrderResult> callback) {
        AsyncCallBack<OrderResult> asyncCallBack = new AsyncCallBack<>(
                act, callback, OrderResult.class);
        post(getAbsoluteUrl("/custServiceOrder/waitComment"), dto,
                asyncCallBack);
    }


    /**
     * 已完成订单
     * @param act
     * @param dto
     * @param callback
     */
    public static void completed(Activity act, OrderDTO
            dto, CallBack<OrderResult> callback) {
        AsyncCallBack<OrderResult> asyncCallBack = new AsyncCallBack<>(
                act, callback, OrderResult.class);
        post(getAbsoluteUrl("/custServiceOrder/finished"), dto,
                asyncCallBack);
    }

    /**
     * 全部订单
     * @param act
     * @param dto
     * @param callback
     */
    public static void whole(Activity act, OrderDTO
            dto, CallBack<OrderResult> callback) {
        AsyncCallBack<OrderResult> asyncCallBack = new AsyncCallBack<>(
                act, callback, OrderResult.class);
        post(getAbsoluteUrl("/custServiceOrder/all"), dto,
                asyncCallBack);
    }



}
