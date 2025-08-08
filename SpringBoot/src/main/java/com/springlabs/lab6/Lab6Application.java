package com.springlabs.lab6;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Lab6Application {
    
    private static final Logger logger = LoggerFactory.getLogger(Lab6Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Lab6Application.class, args);
    }
    
    @Bean
    public CommandLineRunner hintRunner() {
        return args -> {
            logger.info("Application started successfully!");
            logger.info("Access the index page at: http://localhost:8080/");
        };
    }
}