package com.picsartacademy.dao.impl;

import com.picsartacademy.dao.OrderDAO;
import com.picsartacademy.entity.MenuItem;
import com.picsartacademy.entity.Order;
import com.picsartacademy.entity.OrderItem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class OrderDAOImpl implements OrderDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Long placeOrder(Order order) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(order);
        return (Long) session.getIdentifier(order);
    }

    @Override
    public Order viewOrder(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Order.class, id);
    }

    @Override
    public void cancelOrder(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Order> query = session.createQuery("delete from Order WHERE id =:orderId");
        query.setParameter("orderId", id);
        query.executeUpdate();
    }



    @Override
    public Order modifyOrder(Long id, List<OrderItem> items) {
        Session session = sessionFactory.getCurrentSession();
        Order order = session.get(Order.class, id);

        for (OrderItem item : items) {
            for (OrderItem orderItem : order.getItems()) {
                if (orderItem.getId().equals(item.getId())) {
                    orderItem.setQuantity(item.getQuantity());
                    break;
                }
            }
        }

        session.update(order);
        return order;
    }



    @Override
    public List<Order> viewPastOrders(String startDate, String endDate) {
        Session session = sessionFactory.getCurrentSession();
        Query<Order> query = session.createQuery("from Order where orderDate between :startDate and :endDate", Order.class);
        query.setParameter("startDate", LocalDate.parse(startDate));
        query.setParameter("endDate", LocalDate.parse(endDate));
        return query.getResultList();
    }
}
