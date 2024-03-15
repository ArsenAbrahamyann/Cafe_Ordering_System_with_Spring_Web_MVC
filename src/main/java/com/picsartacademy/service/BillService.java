package com.picsartacademy.service;

import com.picsartacademy.entity.Bill;

public interface BillService {
    Bill generateBill(Long orderId);
}
