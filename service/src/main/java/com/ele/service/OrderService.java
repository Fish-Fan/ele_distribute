package com.ele.service;

import com.ele.dto.OrderDetail;
import com.ele.pojo.Order;
import com.ele.pojo.OrderFood;
import com.ele.pojo.Shop;
import com.ele.pojo.User;

import java.util.List;

/**
 * Created by yanfeng-mac on 2017/7/24.
 */
public interface OrderService {

    Integer insertShopCartData(OrderDetail orderDetail, User user);

    Integer insertOrder(Order order);

    void insertFoodList(List<OrderFood> foodList);

    Order findOrderById(Integer orderId);

    List<Order> findHistoryOrderByUserId(Integer userId);

    void orderPaid(Order order);

    void orderChanged(Order order);

    void confirmGetDelivery(Integer orderId,Shop shop);

    Order changeUserToNoName(Order order);

    Double computedDeliveryTime(Integer shopId);

    void updateShopDeliveryTime(Shop shop);

    void updateFoodMonthlyCounts(List<OrderFood> foodList);

    List<Order> selectOrderByDay(Integer shopId);

    List<Order> selectOrderByWeek(Integer shopId);

    List<Order> selectOrderByMonth(Integer shopId);

    List<Order> selectUnGetOrderByNowDays();

    List<Order> selectGetOrderByNowDays();

    List<Order> selectFinishOrderByNowDays();


}
