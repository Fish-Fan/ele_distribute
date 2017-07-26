package com.ele.service;

import com.ele.pojo.*;

/**
 * Created by yanfeng-mac on 2017/7/24.
 */
public interface ShopManagerService {
    ShopManager loginShopManager(ShopManager shopManager);

    Integer insertShopManager(ShopManager shopManager);

    MenuType insertMenuType(MenuType menuType);

    Integer deleteMenuType(Integer menuType);

    MenuType updateMenuType(MenuType menuType);

    Integer selectNowDaysSalesAmount(Integer shopId);

    Integer selectNowMonthySalesAmount(Integer shopId);

    Integer selectNowYearSalesAmount(Integer shopId);

    Integer insertFoodToShop(ShopFood shopFood);

    Integer deleteFoodToShop(Integer shopFoodId);

    ShopFood updateFoodToShop(ShopFood shopFood);

    Integer deleteShopMenu(Integer id);

    Integer insertShopMenu(FoodType foodType);

    FoodType updateShopMenu(FoodType foodType);

    Integer deleteShopActivity(Integer id);

    Integer insertShopActivity(ShopDiscountDesc shopDiscountDesc);

    ShopDiscountDesc updateShopActivity(ShopDiscountDesc shopDiscountDesc);
}
