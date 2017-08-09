package com.ele.pojo;

import java.io.Serializable;

/**
 * Created by yanfeng-mac on 2017/6/27.
 */
public class ShopType implements Serializable {
    private Integer id;
    private String shopType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShopType() {
        return shopType;
    }

    public void setShopType(String shopType) {
        this.shopType = shopType;
    }

    @Override
    public String toString() {
        return "ShopType{" +
                "id=" + id +
                ", shopType='" + shopType + '\'' +
                '}';
    }
}
