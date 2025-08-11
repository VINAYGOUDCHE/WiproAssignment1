package com.example.uberproducer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RideRequest {
    private Long id;
    private String driverName;
    private String passengerName;
    // The location fields are simple strings as per lab description
    private String pickupLocation;
    private String dropLocation;
    private Double fare;
}