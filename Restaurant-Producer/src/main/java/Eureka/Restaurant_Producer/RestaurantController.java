package Eureka.Restaurant_Producer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Arrays;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    @GetMapping
    public List<Restaurant> getRestaurants() {
        return Arrays.asList(
            new Restaurant(1L, "The Golden Spoon", "Bangalore"),
            new Restaurant(2L, "Spice Garden", "Chennai"),
            new Restaurant(3L, "Urban Grill", "Hyderabad")
        );
    }
}