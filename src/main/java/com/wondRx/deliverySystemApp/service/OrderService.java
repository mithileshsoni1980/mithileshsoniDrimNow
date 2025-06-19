package com.wondRx.deliverySystemApp.service;

import com.wondRx.deliverySystemApp.entity.DeliveryOrder;
import com.wondRx.deliverySystemApp.entity.DeliveryTruck;
import com.wondRx.deliverySystemApp.repository.DeliveryOrderRepository;
import com.wondRx.deliverySystemApp.repository.DeliveryTruckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private DeliveryOrderRepository orderRepository;

    @Autowired
    private DeliveryTruckRepository truckRepository;

    public DeliveryOrder submitOrder(DeliveryOrder order) {
        order.setSubmittedAt(LocalDateTime.now());

        // Save order first
        DeliveryOrder savedOrder = orderRepository.save(order);

        // Try auto-assignment
        assignOrderToTruck(savedOrder);

        return orderRepository.save(savedOrder); // Save again if truck assigned
    }

    private void assignOrderToTruck(DeliveryOrder order) {
        List<DeliveryTruck> trucks = truckRepository.findAll();

        // Filter by matching postal zone (first 3 digits)
        String zone = order.getPostalCode().substring(0, 3);

        List<DeliveryTruck> candidateTrucks = trucks.stream()
                .filter(truck ->
                        truck.getPostalZone().equals(zone) &&
                                truck.getCurrentWeight() + order.getWeight() <= truck.getMaxWeight() &&
                                truck.getCurrentVolume() + order.getVolume() <= truck.getMaxVolume()
                )
                .sorted(Comparator.comparing(DeliveryTruck::getCurrentWeight)) // lightest truck first
                .collect(Collectors.toList());

        if (!candidateTrucks.isEmpty()) {
            DeliveryTruck assignedTruck = candidateTrucks.get(0);
            assignedTruck.setCurrentWeight(assignedTruck.getCurrentWeight() + order.getWeight());
            assignedTruck.setCurrentVolume(assignedTruck.getCurrentVolume() + order.getVolume());
            truckRepository.save(assignedTruck);
            order.setAssignedTruck(assignedTruck);
        }
    }

    public List<DeliveryOrder> getOrdersForDay(LocalDate date) {
        return orderRepository.findAllBySubmittedAtBetween(
                date.atStartOfDay(), date.atTime(LocalTime.MAX)
        );
    }
}
