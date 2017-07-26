package com.ele.service;

import com.ele.pojo.MenuTypeReal;
import com.ele.pojo.Shop;

import java.util.List;

/**
 * Created by yanfeng-mac on 2017/7/24.
 */
public interface MenuService {
    MenuTypeReal insertShopToMenu(MenuTypeReal menuTypeReal);

    List<Shop> selectShopFoodByMenuTypeId(Integer shopId);


}
