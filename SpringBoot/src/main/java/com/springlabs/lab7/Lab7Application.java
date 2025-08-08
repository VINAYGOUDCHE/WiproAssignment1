package com.springlabs.lab7;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Lab7Application {
    
    private static final Logger logger = LoggerFactory.getLogger(Lab7Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Lab7Application.class, args);
    }
    
    @Bean
    public CommandLineRunner lab7HintRunner() {
        return args -> {
            logger.info("Application started successfully!");
            // The FormController maps the root URL to the form.
            logger.info("Access the enrollment form at: http://localhost:8080/");
        };
    }
}