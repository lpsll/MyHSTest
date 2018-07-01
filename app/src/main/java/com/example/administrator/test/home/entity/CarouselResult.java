package com.example.administrator.test.home.entity;

import com.example.administrator.test.common.entity.BaseEntity;

import java.util.List;

/**
 * Created by lenovo on 2016/12/25.
 */
public class CarouselResult extends BaseEntity {
    List<CarouselEntity> data;
    public List<CarouselEntity> getData() {
        return data;
    }

    public void setData(List<CarouselEntity> data) {
        this.data = data;
    }
}
