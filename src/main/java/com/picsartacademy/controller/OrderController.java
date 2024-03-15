package com.picsartacademy.controller;

import com.picsartacademy.entity.Order;
import com.picsartacademy.entity.OrderItem;
import com.picsartacademy.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<Map<String, Long>> placeOrder(@Valid @RequestBody Order order) {
        Long id = orderService.placeOrder(order);
        return new ResponseEntity<>(Map.of("id", id), HttpStatus.CREATED);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Order> viewOrder(@PathVariable("orderId") Long orderId) {
        Order order = orderService.viewOrder(orderId);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PutMapping("/{orderId}")
    public ResponseEntity<Order> modifyOrder(@PathVariable("orderId") Long orderId, @Valid @RequestBody List<OrderItem> items) {
        Order modifiedOrder = orderService.modifyOrder(orderId, items);
        return new ResponseEntity<>(modifiedOrder, HttpStatus.OK);
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<Void> cancelOrder(@PathVariable("orderId") Long orderId) {
        orderService.cancelOrder(orderId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<Order>> viewPastOrders(@RequestBody String startDate, @RequestBody String endDate) {
        List<Order> orderHistory = orderService.viewPastOrders(startDate, endDate);
        return new ResponseEntity<>(orderHistory, HttpStatus.OK);
    }
}
