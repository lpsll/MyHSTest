package com.example.administrator.test.home.entity;

import com.example.administrator.test.common.entity.BaseEntity;

import java.util.List;

/**
 * Created by lenovo on 2016/12/25.
 */
public class FullServiceResult extends BaseEntity {
    List<FullServiceEntity> data;
    public List<FullServiceEntity> getData() {
        return data;
    }

    public void setData(List<FullServiceEntity> data) {
        this.data = data;
    }
}
