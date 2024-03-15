package com.picsartacademy.dao;

import com.picsartacademy.entity.MenuItem;

import java.util.List;

public interface MenuItemDAO {
    public List<MenuItem> getAllMenuItem();
    public void updateMenuItem(Long id,MenuItem menuItem);
    public void addMenuItem(MenuItem menuItem);
    public void removeMenuItem(Long id);
}
