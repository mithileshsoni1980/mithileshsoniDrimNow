package com.wondRx.deliverySystemApp.entity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "DELIVERY_TRUCK")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeliveryTruck {

    @Id
    private String id;

    @Column(name = "max_weight")
    private double maxWeight;

    @Column(name = "max_volume")
    private double maxVolume;

    @Column(name = "current_weight")
    private double currentWeight;

    @Column(name = "current_volume")
    private double currentVolume;

    @Column(name = "postal_zone")
    private String postalZone;
}
