package com.wondRx.deliverySystemApp.controller;

import com.wondRx.deliverySystemApp.entity.DeliveryTruck;
import com.wondRx.deliverySystemApp.service.TruckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/trucks")
public class TruckController {

    @Autowired
    private TruckService truckService;

    @GetMapping
    public List<DeliveryTruck> getAll() {
        return truckService.getAllTrucks();
    }
}

