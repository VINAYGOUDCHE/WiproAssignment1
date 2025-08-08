package com.springlabs.lab8;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Lab8Application {

    private static final Logger logger = LoggerFactory.getLogger(Lab8Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Lab8Application.class, args);
    }

    @Bean
    public CommandLineRunner greetingRunner() {
        return args -> {
            logger.info("Application started successfully!");
            logger.info("Send a POST request to: http://localhost:8080/users with a JSON body.");
        };
    }
}