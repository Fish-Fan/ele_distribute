package com.ele.pojo;

import java.io.Serializable;

/**
 * Created by yanfeng-mac on 2017/6/28.
 */
public class DtoDiscountDesc implements Serializable{
    private Integer id;
    private String discountDesc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDiscountDesc() {
        return discountDesc;
    }

    public void setDiscountDesc(String discountDesc) {
        this.discountDesc = discountDesc;
    }

    @Override
    public String toString() {
        return "ShopDiscountDesc{" +
                "id=" + id +
                ", discountDesc='" + discountDesc + '\'' +
                '}';
    }
}
