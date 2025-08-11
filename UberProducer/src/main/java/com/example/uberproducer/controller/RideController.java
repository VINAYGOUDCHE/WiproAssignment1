package com.example.uberproducer.controller;

import com.example.uberproducer.dto.RideMessage;
import com.example.uberproducer.dto.RideRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rides")
public class RideController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private final ObjectMapper objectMapper = new ObjectMapper();

    private static final String TOPIC = "uber-ride-topic";

    @PostMapping
    public String createRide(@RequestBody RideRequest rideRequest) throws Exception {
        String jsonMessage = objectMapper.writeValueAsString(new RideMessage("CREATE", rideRequest));
        kafkaTemplate.send(TOPIC, jsonMessage);
        return "Ride creation request sent to Kafka.";
    }

    @PutMapping("/{id}")
    public String updateRide(@PathVariable Long id, @RequestBody RideRequest rideRequest) throws Exception {
        rideRequest.setId(id);
        String jsonMessage = objectMapper.writeValueAsString(new RideMessage("UPDATE", rideRequest));
        kafkaTemplate.send(TOPIC, jsonMessage);
        return "Ride update request sent to Kafka.";
    }

    @DeleteMapping("/{id}")
    public String deleteRide(@PathVariable Long id) throws Exception {
        RideRequest rideRequest = new RideRequest();
        rideRequest.setId(id);
        String jsonMessage = objectMapper.writeValueAsString(new RideMessage("DELETE", rideRequest));
        kafkaTemplate.send(TOPIC, jsonMessage);
        return "Ride deletion request sent to Kafka.";
    }
}