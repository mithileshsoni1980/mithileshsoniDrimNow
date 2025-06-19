package com.wondRx.deliverySystemApp.controller;


import com.wondRx.deliverySystemApp.entity.DeliveryOrder;
import com.wondRx.deliverySystemApp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public DeliveryOrder submit(@RequestBody DeliveryOrder order) {
        return orderService.submitOrder(order);
    }

    @GetMapping
    public List<DeliveryOrder> getByDate(@RequestParam String date) {
        return orderService.getOrdersForDay(LocalDate.parse(date));
    }
}

