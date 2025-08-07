package Eureka.Restaurant_Producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class RestaurantProducerApplication {

    private static final Logger logger = LoggerFactory.getLogger(RestaurantProducerApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(RestaurantProducerApplication.class, args);
    }

    @Bean
    public CommandLineRunner producerHintRunner() {
        return args -> {
            logger.info("Restaurant Producer is running!");
            logger.info("Access the REST endpoint at: http://localhost:8081/restaurants");
            logger.info("This service is registered with Eureka.");
        };
    }
}