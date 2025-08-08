package com.springlabs.lab13;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    // ✅ Create
    @PostMapping("/user")
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    // 📖 Read All
    @GetMapping("/user")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // 📖 Read by ID
    @GetMapping("/user/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    // ✏️ Update
    @PutMapping("/user/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        return userService.updateUser(id, updatedUser);
    }

    // 🗑️ Delete
    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "User with ID " + id + " deleted successfully.";
    }
}