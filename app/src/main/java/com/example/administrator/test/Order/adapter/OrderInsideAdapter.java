package com.example.administrator.test.Order.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.test.Order.OrderUiGoto;
import com.example.administrator.test.Order.entity.OrderEntity;
import com.example.administrator.test.R;
import com.example.administrator.test.common.AppContext;
import com.example.administrator.test.common.utils.DialogUtils;
import com.example.administrator.test.common.utils.LogUtils;
import com.example.administrator.test.common.utils.StringUtils;
import com.example.administrator.test.common.utils.TimeUtils;
import com.qluxstory.ptrrecyclerview.BaseRecyclerViewHolder;
import com.qluxstory.ptrrecyclerview.BaseSimpleRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

import de.greenrobot.event.EventBus;

/**
 * Created by lenovo on 2016/12/25.
 */
public class OrderInsideAdapter  extends BaseSimpleRecyclerAdapter<OrderEntity> {
    private final Context context;
    private final int type;
    TextView tv05,tv05_phone,tv06,tv07;
    Button btn;
    LinearLayout lin05,lin05_phone,lin06,lin07;
    List<OrderEntity> list = new ArrayList<>();
    private String status;

    public OrderInsideAdapter(Context context, int type) {
        this.context = context;
        this.type = type;
    }

    @Override
    public int getItemViewLayoutId() {
        return R.layout.item_orderinsider;
    }

    @Override
    public void bindData(BaseRecyclerViewHolder holder, OrderEntity orderEntity, final int position) {
        list.add(position,orderEntity);
        status = orderEntity.getStatus();

        String serviceTime= orderEntity.getServiceTime();
        List<String> dateAndTime = StringUtils.getDateAndTime(serviceTime);

        holder.setText(R.id.order_tv01,orderEntity.getServiceName());
        holder.setText(R.id.order_tv02,orderEntity.getOrderNo());
        holder.setText(R.id.order_tv03,dateAndTime.get(0));
        holder.setText(R.id.order_tv04,orderEntity.getAddress());
        holder.setText(R.id.order_tv03_time,dateAndTime.get(1));

        holder.setText(R.id.order_tv_kh_name,orderEntity.getCustName());
        holder.setText(R.id.order_tv_kh_phone,orderEntity.getPhone());

        tv05 = holder.getView(R.id.order_tv05);
        lin05 = holder.getView(R.id.order_lin05);
        tv05_phone = holder.getView(R.id.order_tv05_ipone);
        lin05_phone = holder.getView(R.id.order_lin05_ipone);
        tv06 = holder.getView(R.id.order_tv06);
        lin06 = holder.getView(R.id.order_lin06);
        tv07 = holder.getView(R.id.order_tv07);
        btn = holder.getView(R.id.order_btn);
        tv05_phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //拨打电话
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"
                        + list.get(position).getEmphone()));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            TextView tv = tv07;
            Button bt = btn;
            @Override
            public void onClick(View v) {
            }
        });
        if(status.equals("1")||status.equals("7")||status.equals("8")){
            //未完成订单
            lin05_phone.setVisibility(View.GONE);
            lin05.setVisibility(View.GONE);
            lin06.setVisibility(View.GONE);
            btn.setVisibility(View.VISIBLE);
            tv07.setText("未完成");
            btn.setText("取消订单");
        }
        else if(status.equals("3")){
            //待支付订单
            lin05_phone.setVisibility(View.VISIBLE);
            lin05.setVisibility(View.VISIBLE);
            lin06.setVisibility(View.VISIBLE);
            btn.setVisibility(View.VISIBLE);
            tv05.setText(orderEntity.getEmpName());
            tv06.setText(orderEntity.getServiceFee()+"元");
            tv07.setText("待支付");
            btn.setText("去支付");
            tv05_phone.setText(orderEntity.getEmphone());
        }
        else if(status.equals("4")){
            //待评价订单
            lin05_phone.setVisibility(View.VISIBLE);
            lin05.setVisibility(View.VISIBLE);
            lin06.setVisibility(View.GONE);
            btn.setVisibility(View.VISIBLE);
            tv05.setText(orderEntity.getEmpName());
            tv07.setText("已支付");
            btn.setText("去评价");
            tv05_phone.setText(orderEntity.getEmphone());
        }
        else if(status.equals("5")){
            //已完成订单
            lin05_phone.setVisibility(View.VISIBLE);
            lin05.setVisibility(View.VISIBLE);
            lin06.setVisibility(View.VISIBLE);
            tv05.setText(orderEntity.getEmpName());
            tv06.setText(orderEntity.getServiceFee()+"元");
            tv07.setText("已完成");
            btn.setVisibility(View.GONE);
            tv05_phone.setText(orderEntity.getEmphone());
        }

    }
}
