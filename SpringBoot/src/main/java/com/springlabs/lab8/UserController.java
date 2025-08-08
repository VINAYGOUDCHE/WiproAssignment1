package com.springlabs.lab8;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @PostMapping("/users")
    public String processUser(@RequestBody User user) {
        System.out.println("Received user: " + user.getFirstName() + " " + user.getLastName());
        System.out.println("Age: " + user.getAge());
        return "User with name " + user.getFirstName() + " " + user.getLastName() + " received successfully.";
    }
}