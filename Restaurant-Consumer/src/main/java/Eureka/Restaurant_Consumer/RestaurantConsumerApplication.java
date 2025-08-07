package Eureka.Restaurant_Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class RestaurantConsumerApplication {

    private static final Logger logger = LoggerFactory.getLogger(RestaurantConsumerApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(RestaurantConsumerApplication.class, args);
    }
    
    @Bean
    public CommandLineRunner consumerHintRunner() {
        return args -> {
            logger.info("Restaurant Consumer is running!");
            logger.info("Access the consumer's endpoint to call the producer at: http://localhost:8082/consumer/restaurants");
            logger.info("This service is registered with Eureka and uses Feign to call the producer.");
        };
    }
}