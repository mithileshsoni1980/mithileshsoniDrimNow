package com.wondRx.deliverySystemApp.service;

import com.wondRx.deliverySystemApp.entity.DeliveryOrder;
import com.wondRx.deliverySystemApp.entity.DeliveryTruck;
import com.wondRx.deliverySystemApp.repository.DeliveryOrderRepository;
import com.wondRx.deliverySystemApp.repository.DeliveryTruckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AssignmentService {

    @Autowired
    private DeliveryOrderRepository orderRepository;

    @Autowired
    private DeliveryTruckRepository truckRepository;

    public void assignOrders() {
        List<DeliveryOrder> unassignedOrders = orderRepository.findAllByAssignedTruckIsNullOrderByPriorityAscSubmittedAtAsc();
        List<DeliveryTruck> trucks = truckRepository.findAll();

        for (DeliveryOrder order : unassignedOrders) {
            DeliveryTruck assigned = trucks.stream()
                    .filter(truck ->
                            truck.getPostalZone().equals(order.getPostalCode().substring(0, 3)) &&
                                    truck.getCurrentWeight() + order.getWeight() <= truck.getMaxWeight() &&
                                    truck.getCurrentVolume() + order.getVolume() <= truck.getMaxVolume()
                    )
                    .findFirst()
                    .orElse(null);

            if (assigned != null) {
                assigned.setCurrentWeight(assigned.getCurrentWeight() + order.getWeight());
                assigned.setCurrentVolume(assigned.getCurrentVolume() + order.getVolume());
                order.setAssignedTruck(assigned);

                truckRepository.save(assigned);
                orderRepository.save(order);
            }
        }
    }

    public List<DeliveryOrder> getAssignments() {
        return orderRepository.findAll().stream()
                .filter(order -> order.getAssignedTruck() != null)
                .collect(Collectors.toList());
    }

    public List<DeliveryOrder> getAssignmentsForTruck(String truckId) {
        return orderRepository.findAll().stream()
                .filter(order -> order.getAssignedTruck() != null && order.getAssignedTruck().getId().equals(truckId))
                .collect(Collectors.toList());
    }
}

