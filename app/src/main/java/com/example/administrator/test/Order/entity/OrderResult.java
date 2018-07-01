package com.example.administrator.test.Order.entity;

import com.example.administrator.test.common.entity.BaseEntity;

/**
 * Created by lenovo on 2016/12/25.
 */
public class OrderResult extends BaseEntity {
    OrderData data;

    public OrderData getData() {
        return data;
    }

    public void setData(OrderData data) {
        this.data = data;
    }
}
