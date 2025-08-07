package Eureka.EurekaServer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {

    private static final Logger logger = LoggerFactory.getLogger(EurekaServerApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class, args);
    }
    
    @Bean
    public CommandLineRunner eurekaServerHintRunner() {
        return args -> {
            logger.info("Eureka Server is running!");
            logger.info("Access the Eureka dashboard at: http://localhost:8761");
            logger.info("Access the REST endpoint Only After Running Producer at: http://localhost:8081/restaurants");
            logger.info("Access the consumer's endpoint to call the producer only after running consumer at: http://localhost:8082/consumer/restaurants");
        };
    }
}