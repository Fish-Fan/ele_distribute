package com.ele.pojo;

import java.io.Serializable;

/**
 * Created by yanfeng-mac on 2017/6/27.
 */
public class ShopImg implements Serializable {
    private Integer id;
    private String shopImg;
    private Integer shopId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShopImg() {
        return shopImg;
    }

    public void setShopImg(String shopImg) {
        this.shopImg = shopImg;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    @Override
    public String toString() {
        return "ShopImg{" +
                "id=" + id +
                ", shopImg='" + shopImg + '\'' +
                ", shopId=" + shopId +
                '}';
    }
}
