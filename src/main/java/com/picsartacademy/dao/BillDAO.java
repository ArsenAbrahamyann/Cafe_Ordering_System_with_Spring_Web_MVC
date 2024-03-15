package com.picsartacademy.dao;

import com.picsartacademy.entity.Bill;

public interface BillDAO {
    Bill generateBill(Long orderId);
}
