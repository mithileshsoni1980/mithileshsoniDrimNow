package com.wondRx.deliverySystemApp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeliveryOrder {

    @Id
    @GeneratedValue
    private UUID id;

    private String customerName;
    private double weight;
    private double volume;
    private String postalCode;

    @Enumerated(EnumType.STRING)
    private OrderPriority priority;

    private LocalDateTime submittedAt;

    @ManyToOne
    private DeliveryTruck assignedTruck;

    // Getters and Setters
}

