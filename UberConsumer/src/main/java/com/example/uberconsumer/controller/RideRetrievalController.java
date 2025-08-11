package com.example.uberconsumer.controller;

import com.example.uberconsumer.entity.Ride;
import com.example.uberconsumer.repository.RideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rides")
public class RideRetrievalController {

    @Autowired
    private RideRepository rideRepository;

    @GetMapping
    public List<Ride> getAllRides() {
        return rideRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ride> getRideById(@PathVariable Long id) {
        return rideRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}