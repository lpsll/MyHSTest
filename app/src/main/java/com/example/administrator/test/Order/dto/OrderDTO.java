package com.example.administrator.test.Order.dto;

import com.example.administrator.test.common.dto.BaseDTO;

/**
 * Created by lenovo on 2016/12/25.
 */
public class OrderDTO extends BaseDTO {
    private String page;
    private String size;

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

}
