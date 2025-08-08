package com.springlabs.lab5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Lab5Application {
    
    private static final Logger logger = LoggerFactory.getLogger(Lab5Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Lab5Application.class, args);
    }
    
    @Bean
    public CommandLineRunner hintRunner() {
        return args -> {
            logger.info("Application started successfully!");
            logger.info("Access the Redirection endpoint at: http://localhost:8080/example/test");
        };
    }
}