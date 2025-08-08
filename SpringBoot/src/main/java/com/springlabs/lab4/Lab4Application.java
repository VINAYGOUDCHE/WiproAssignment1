package com.springlabs.lab4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Lab4Application {

    private static final Logger logger = LoggerFactory.getLogger(Lab4Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Lab4Application.class, args);
    }

    @Bean
    public CommandLineRunner greetingRunner() {
        return args -> {
            logger.info("Application started successfully!");
            logger.info("Access the API at: http://localhost:8080/users/101/accounts?type=current&status=active");
        };
    }
}