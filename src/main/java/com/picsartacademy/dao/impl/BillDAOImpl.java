package com.picsartacademy.dao.impl;

import com.picsartacademy.dao.BillDAO;
import com.picsartacademy.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BillDAOImpl implements BillDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Bill generateBill(Long orderId) {
        Session session = sessionFactory.getCurrentSession();
        Order order = session.get(Order.class, orderId);
        if (order == null) {
            throw  new RuntimeException("Order not found with id: " + orderId);
        }
        double totalAmount = 0.0;
        for (OrderItem orderItem:order.getItems()) {
            MenuItem menuItem = orderItem.getMenuItem();
            totalAmount += menuItem.getPrice() * orderItem.getQuantity();
        }
        Bill bill = new Bill();
        bill.setTotalAmount(totalAmount);
        bill.setOrderId(orderId);

        return bill;
    }
}
