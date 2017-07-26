package com.ele.service;

import com.ele.dto.Goods;
import com.ele.pojo.DtoDiscountDesc;
import com.ele.pojo.Shop;
import com.ele.pojo.ShopImg;
import com.ele.pojo.ShopReward;

import java.util.List;

/**
 * Created by yanfeng-mac on 2017/7/24.
 */
public interface ShopService {
    Shop findById(Integer id);

    List<DtoDiscountDesc> findDiscountDescById(Integer id);

    List<ShopImg> findShopImgById(Integer id);

    List<Goods> findShopGoodsById(Integer id);

    List<ShopReward> findShopRewardByShopId(Integer shopId);

    List<Shop> findBasicShopMsgOrderByServer();

    Integer getShopCollectCount(Integer shopId);

    Integer insertShop(Shop shop);
}
