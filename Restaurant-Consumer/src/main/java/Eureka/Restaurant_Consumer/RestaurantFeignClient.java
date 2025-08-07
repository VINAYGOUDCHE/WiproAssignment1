package Eureka.Restaurant_Consumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@FeignClient(name = "restaurant-producer")
public interface RestaurantFeignClient {
    @GetMapping("/restaurants")
    List<Restaurant> getRestaurants();
}