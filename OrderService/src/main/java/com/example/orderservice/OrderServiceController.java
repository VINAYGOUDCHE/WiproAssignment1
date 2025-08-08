package com.example.orderservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderServiceController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/order")
    public String createOrder() {
        String paymentResponse = restTemplate.getForObject("http://localhost:8082/payment", String.class);
        return "Order created. " + paymentResponse;
    }
}