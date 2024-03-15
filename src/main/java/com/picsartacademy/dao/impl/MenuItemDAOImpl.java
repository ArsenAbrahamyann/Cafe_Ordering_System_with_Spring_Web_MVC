package com.picsartacademy.dao.impl;

import com.picsartacademy.dao.MenuItemDAO;
import com.picsartacademy.entity.Bill;
import com.picsartacademy.entity.MenuItem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MenuItemDAOImpl implements MenuItemDAO {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List<MenuItem> getAllMenuItem() {
        Session session = sessionFactory.getCurrentSession();
        List<MenuItem>  allMenuItems = session.createQuery("from MenuItem ", MenuItem.class).getResultList();
        return allMenuItems;
    }

    @Override
    public void updateMenuItem(Long id, MenuItem menuItem) {
        Session session = sessionFactory.getCurrentSession();
        MenuItem menuItem1 = session.get(MenuItem.class, id);
        menuItem1.setCategory(menuItem.getCategory());
        menuItem1.setDescription(menuItem.getDescription());
        menuItem1.setName(menuItem.getName());
        menuItem1.setPrice(menuItem.getPrice());
        session.persist(menuItem1);
    }

    @Override
    public void addMenuItem(MenuItem menuItem) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(menuItem);
    }

    @Override
    public void removeMenuItem(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Query<MenuItem> query = session.createQuery("delete from MenuItem WHERE id =:menuItemId");
        query.setParameter("menuItemId", id);
        query.executeUpdate();
    }
}
