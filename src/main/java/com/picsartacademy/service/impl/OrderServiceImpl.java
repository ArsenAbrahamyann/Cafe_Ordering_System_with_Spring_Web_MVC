package com.picsartacademy.service.impl;

import com.picsartacademy.dao.OrderDAO;
import com.picsartacademy.entity.Order;
import com.picsartacademy.entity.OrderItem;
import com.picsartacademy.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDAO orderDAO;

    @Override
    @Transactional
    public Long placeOrder(Order order) {
        return orderDAO.placeOrder(order);

    }

    @Override
    @Transactional
    public Order viewOrder(Long id) {
        return orderDAO.viewOrder(id);
    }

    @Override
    @Transactional
    public void cancelOrder(Long id) {
        orderDAO.cancelOrder(id);
    }

    @Override
    @Transactional
    public Order modifyOrder(Long id, List<OrderItem> items) {
        return orderDAO.modifyOrder(id,items);
    }

    @Override
    @Transactional
    public List<Order> viewPastOrders(String startDate, String endDate) {
        return orderDAO.viewPastOrders(startDate,endDate);
    }
}
