package com.springlabs.lab11;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Lab11Application {

    private static final Logger logger = LoggerFactory.getLogger(Lab11Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Lab11Application.class, args);
    }

    @Bean
    public CommandLineRunner greetingRunner() {
        return args -> {
            logger.info("Application started successfully!");
            logger.info("Access your API at: http://localhost:8080/springrest/customers");
        };
    }
}