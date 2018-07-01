package com.example.administrator.test.Order.entity;

import com.example.administrator.test.common.entity.BaseEntity;

import java.util.List;

/**
 * Created by lenovo on 2016/12/25.
 */
public class OrderData extends BaseEntity {
    private String page;
    private String pageCount;
    private String total;
    List<OrderEntity> data;

    public List<OrderEntity> getData() {
        return data;
    }

    public void setData(List<OrderEntity> data) {
        this.data = data;
    }


    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getPageCount() {
        return pageCount;
    }

    public void setPageCount(String pageCount) {
        this.pageCount = pageCount;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

}
