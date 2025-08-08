package com.springlabs.lab3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Lab3Application {
    
    private static final Logger logger = LoggerFactory.getLogger(Lab3Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Lab3Application.class, args);
    }
    
    @Bean
    public CommandLineRunner hintRunner() {
        return args -> {
            logger.info("Application started successfully!");
            logger.info("Access the Registration Form at: http://localhost:8080/SpringMvcFormExample/register");
        };
    }
}