package com.example.uberconsumer.service;

import com.example.uberconsumer.entity.Ride;
import com.example.uberconsumer.repository.RideRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @Autowired
    private RideRepository rideRepository;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener(topics = "uber-ride-topic", groupId = "uber_ride_group")
    public void consume(String message) {
        try {
            JsonNode jsonNode = objectMapper.readTree(message);
            String operation = jsonNode.get("operation").asText();
            JsonNode rideDataNode = jsonNode.get("rideData");
            Ride ride = objectMapper.treeToValue(rideDataNode, Ride.class);

            switch (operation) {
                case "CREATE":
                case "UPDATE":
                    rideRepository.save(ride);
                    System.out.println("Saved ride: " + ride);
                    break;
                case "DELETE":
                    rideRepository.deleteById(ride.getId());
                    System.out.println("Deleted ride with id: " + ride.getId());
                    break;
                default:
                    System.out.println("Unknown operation: " + operation);
            }
        } catch (Exception e) {
            System.err.println("Error processing Kafka message: " + e.getMessage());
            e.printStackTrace();
        }
    }
}