package Eureka.Restaurant_Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @Autowired
    private RestaurantFeignClient feignClient;

    @GetMapping("/restaurants")
    public List<Restaurant> getRestaurants() {
        return feignClient.getRestaurants();
    }
}