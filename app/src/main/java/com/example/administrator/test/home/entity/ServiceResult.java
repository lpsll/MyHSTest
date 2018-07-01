package com.example.administrator.test.home.entity;

import com.example.administrator.test.common.entity.BaseEntity;

/**
 * Created by lenovo on 2016/12/25.
 */
public class ServiceResult extends BaseEntity {
    ServiceData data;
    public ServiceData getData() {
        return data;
    }

    public void setData(ServiceData data) {
        this.data = data;
    }
}
