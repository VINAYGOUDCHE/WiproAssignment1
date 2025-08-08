package com.springlabs.lab4;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @GetMapping("/users/{id}/accounts")
    public String getAccounts(
            @PathVariable String id,
            @RequestParam String type,
            @RequestParam String status) {

        return "User ID: " + id + ", Account Type: " + type + ", Status: " + status;
    }
}

