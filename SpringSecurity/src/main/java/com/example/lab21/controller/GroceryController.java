package com.example.lab21.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/grocery")
public class GroceryController {

    @GetMapping("/public")
    public String getPublicMessage() {
        return "Welcome to the public page!";
    }

    @GetMapping("/items")
    public String getGroceryItems() {
        return "List of grocery items (secured).";
    }

    @GetMapping("/orders")
    public String getGroceryOrders() {
        return "List of grocery orders (secured).";
    }

}