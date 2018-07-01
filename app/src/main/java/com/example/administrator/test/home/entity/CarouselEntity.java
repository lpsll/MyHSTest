package com.example.administrator.test.home.entity;

import com.example.administrator.test.common.entity.BaseEntity;

/**
 * Created by lenovo on 2016/12/25.
 */
public class CarouselEntity extends BaseEntity {
    private String id;
    private String creationTimestamp;
    private String modificationTimestamp;
    private String deleteRemark;
    private String bannertitle;
    private String bannerimg;
    private String bannerurl;
    private String bannerlocation;
    private String bannerorder;
    private String status;
    private String creater;
    private String createdate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreationTimestamp() {
        return creationTimestamp;
    }

    public void setCreationTimestamp(String creationTimestamp) {
        this.creationTimestamp = creationTimestamp;
    }

    public String getModificationTimestamp() {
        return modificationTimestamp;
    }

    public void setModificationTimestamp(String modificationTimestamp) {
        this.modificationTimestamp = modificationTimestamp;
    }

    public String getDeleteRemark() {
        return deleteRemark;
    }

    public void setDeleteRemark(String deleteRemark) {
        this.deleteRemark = deleteRemark;
    }

    public String getBannertitle() {
        return bannertitle;
    }

    public void setBannertitle(String bannertitle) {
        this.bannertitle = bannertitle;
    }

    public String getBannerimg() {
        return bannerimg;
    }

    public void setBannerimg(String bannerimg) {
        this.bannerimg = bannerimg;
    }

    public String getBannerurl() {
        return bannerurl;
    }

    public void setBannerurl(String bannerurl) {
        this.bannerurl = bannerurl;
    }

    public String getBannerlocation() {
        return bannerlocation;
    }

    public void setBannerlocation(String bannerlocation) {
        this.bannerlocation = bannerlocation;
    }

    public String getBannerorder() {
        return bannerorder;
    }

    public void setBannerorder(String bannerorder) {
        this.bannerorder = bannerorder;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate;
    }
}
