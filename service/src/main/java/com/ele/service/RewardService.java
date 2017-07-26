package com.ele.service;

import com.ele.dto.RewardDTO;
import com.ele.pojo.FoodReward;
import com.ele.pojo.Order;
import com.ele.pojo.OrderImg;
import com.ele.pojo.ShopReward;

import java.util.List;

/**
 * Created by yanfeng-mac on 2017/7/24.
 */
public interface RewardService {
    void insertReward(RewardDTO rewardDTO, Order order);

    void insertOrderImg(OrderImg orderImg);

    ShopReward changeRewardToNoName(ShopReward shopReward);

    List<FoodReward> changeFoodRewardToNoName(List<FoodReward> foodRewardList);
}
