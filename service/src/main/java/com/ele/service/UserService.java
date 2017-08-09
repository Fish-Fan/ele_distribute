package com.ele.service;

import com.ele.pojo.Like;
import com.ele.pojo.User;
import com.ele.pojo.UserAddress;

import java.util.List;

/**
 * Created by yanfeng-mac on 2017/7/24.
 */
public interface UserService {
    User findById(Integer userId);

    User loginUser(User user);

    boolean registUser(User user);

    List<Like> getCollectShopByUserId(Integer userId);

    void collectShop(Like like);

    void unCollectShop(Like like);

    List<UserAddress> getUserAddress(User user);

    void updateUserAddress(UserAddress userAddress);

    Integer addUserAddress(UserAddress userAddress);

    void delectUserAddress(UserAddress userAddress);

    void updateAvatar(User user);

    void updateUserName(User user);

    void updateLastAddress(User user);

    boolean userIsLikeShop(User user, Integer shopId);

    boolean checkUserHasAddress(User user,Integer addressId);
}
