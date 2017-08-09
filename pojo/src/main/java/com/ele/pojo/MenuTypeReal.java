package com.ele.pojo;

import java.io.Serializable;

/**
 * Created by yanfeng-mac on 2017/7/13.
 */
public class MenuTypeReal implements Serializable{
    private Integer id;
    private Integer shopId;
    private Integer menuTypeId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Integer getMenuTypeId() {
        return menuTypeId;
    }

    public void setMenuTypeId(Integer menuTypeId) {
        this.menuTypeId = menuTypeId;
    }

    @Override
    public String toString() {
        return "MenuTypeReal{" +
                "id=" + id +
                ", shopId=" + shopId +
                ", menuTypeId=" + menuTypeId +
                '}';
    }
}
