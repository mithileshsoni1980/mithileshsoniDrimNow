package com.wondRx.deliverySystemApp.repository;

import com.wondRx.deliverySystemApp.entity.DeliveryTruck;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryTruckRepository extends JpaRepository<DeliveryTruck, String> {
}

