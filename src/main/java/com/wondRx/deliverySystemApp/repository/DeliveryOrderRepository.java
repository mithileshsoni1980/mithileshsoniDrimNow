package com.wondRx.deliverySystemApp.repository;

import com.wondRx.deliverySystemApp.entity.DeliveryOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface DeliveryOrderRepository extends JpaRepository<DeliveryOrder, UUID> {
    List<DeliveryOrder> findAllBySubmittedAtBetween(LocalDateTime start, LocalDateTime end);
    List<DeliveryOrder> findAllByAssignedTruckIsNullOrderByPriorityAscSubmittedAtAsc();
}

