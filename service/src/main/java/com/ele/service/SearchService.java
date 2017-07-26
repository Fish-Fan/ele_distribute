package com.ele.service;

import com.ele.pojo.Shop;
import com.ele.pojo.ShopFood;

import java.util.List;

/**
 * Created by yanfeng-mac on 2017/7/24.
 */
public interface SearchService {
    List<Shop> findShopByLikeName(String searchValue);

    List<ShopFood> findFoodByLikeName(String searchValue);
}
