package com.wondRx.deliverySystemApp.service;

import com.wondRx.deliverySystemApp.entity.DeliveryTruck;
import com.wondRx.deliverySystemApp.repository.DeliveryTruckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TruckService {

    @Autowired
    private DeliveryTruckRepository truckRepository;

    public List<DeliveryTruck> getAllTrucks() {
        return truckRepository.findAll();
    }

    public Optional<DeliveryTruck> getTruck(String id) {
        return truckRepository.findById(id);
    }

    public DeliveryTruck save(DeliveryTruck truck) {
        return truckRepository.save(truck);
    }
}
