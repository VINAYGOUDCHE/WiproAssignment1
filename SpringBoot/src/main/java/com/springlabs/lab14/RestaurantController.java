package com.springlabs.lab14;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private FoodRepository foodRepository;

    // POST /api/restaurants - Create a new restaurant
    @PostMapping
    public ResponseEntity<Restaurant> createRestaurant(@Valid @RequestBody Restaurant restaurant) {
        Restaurant savedRestaurant = restaurantRepository.save(restaurant);
        return new ResponseEntity<>(savedRestaurant, HttpStatus.CREATED);
    }

    // GET /api/restaurants - Get all restaurants
    @GetMapping
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    // GET /api/restaurants/{id} - Get a restaurant by ID
    @GetMapping("/{id}")
    public Restaurant getRestaurantById(@PathVariable Long id) {
        return restaurantRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Restaurant not found"));
    }

    // DELETE /api/restaurants/{id} - Delete a restaurant by ID
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRestaurant(@PathVariable Long id) {
        restaurantRepository.deleteById(id);
    }

    // POST /api/restaurants/{id}/foods - Add a food item to a restaurant
    @PostMapping("/{id}/foods")
    public ResponseEntity<Food> addFoodToRestaurant(@PathVariable Long id, @Valid @RequestBody Food food) {
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Restaurant not found"));

        food.setRestaurant(restaurant);
        Food savedFood = foodRepository.save(food);
        return new ResponseEntity<>(savedFood, HttpStatus.CREATED);
    }

    // DELETE /api/restaurants/foods/{foodId} - Delete a food item by ID
    @DeleteMapping("/foods/{foodId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteFoodItem(@PathVariable Long foodId) {
        foodRepository.deleteById(foodId);
    }
}