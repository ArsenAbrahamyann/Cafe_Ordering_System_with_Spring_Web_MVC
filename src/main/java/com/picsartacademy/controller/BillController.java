package com.picsartacademy.controller;

import com.picsartacademy.entity.Bill;
import com.picsartacademy.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("api/bill")
public class BillController {
    @Autowired
    private BillService billService;

    @GetMapping("/{orderId}")
    public ResponseEntity<Bill> generateBill(@PathVariable("billId") Long orderId) {
        Bill bill = billService.generateBill(orderId);
        return new ResponseEntity<>(bill, HttpStatus.OK);
    }
}
