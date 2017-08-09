package com.ele.util;

import com.ele.pojo.Order;
import com.ele.pojo.OrderFood;
import com.ele.pojo.ShopFood;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by yanfeng-mac on 2017/7/10.
 */
public class EleUtil {

    /**
     * 将ShopFood类型转换为OrderFood类型
     * @param foodList
     * @param orderId
     * @return
     */
    public static List<OrderFood> ShopFoodCastToOrderFood(List<ShopFood> foodList, Integer orderId) {
        List<OrderFood> orderFoodList = new ArrayList<>();
        for(ShopFood food: foodList) {
            OrderFood orderFood = new OrderFood();
            orderFood.setId(food.getId());
            orderFood.setOrderId(orderId);
            orderFood.setFoodCount(food.getCount());
            orderFood.setFoodName(food.getFoodName());
            orderFood.setFoodId(food.getId());
            orderFood.setFoodPrice(food.getPrice());

            orderFoodList.add(orderFood);
        }
        return orderFoodList;
    }



    /**
     * 计算时间差，返回相差的分钟数
     * @param d1
     * @param d2
     * @return
     */
    public static long getTimeMinus(Date d1,Date d2) {
        // 毫秒ms
        long diff = d2.getTime() - d1.getTime();

        long diffSeconds = diff / 1000 % 60;
        long diffMinutes = diff / (60 * 1000);
        return diffMinutes;
    }



    /**
     * 检查是否是匿名用户
     * @param order
     * @return
     */
    public static boolean checkIsNoName(Order order) {
        String result = order.getIsNoName();
        if("true".equals(result)) {
            return true;
        }
        return false;
    }
}
