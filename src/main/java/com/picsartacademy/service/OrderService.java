package com.picsartacademy.service;

import com.picsartacademy.entity.Order;
import com.picsartacademy.entity.OrderItem;

import java.util.List;

public interface OrderService {

    public Long placeOrder(Order order);
    public Order viewOrder(Long id);
    public void cancelOrder(Long id);

    Order modifyOrder(Long id, List<OrderItem> items);
    List<Order> viewPastOrders(String startDate, String endDate);
}
