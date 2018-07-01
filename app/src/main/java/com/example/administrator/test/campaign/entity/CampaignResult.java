package com.example.administrator.test.campaign.entity;

import com.example.administrator.test.common.entity.BaseEntity;

import java.util.List;

/**
 * Created by lenovo on 2016/12/25.
 */
public class CampaignResult extends BaseEntity {
    private List<CampaignEntity> data;

    public List<CampaignEntity> getData() {
        return data;
    }

    public void setData(List<CampaignEntity> data) {
        this.data = data;
    }
}
