package com.springlabs.lab10;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Lab10Application {

    private static final Logger logger = LoggerFactory.getLogger(Lab10Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Lab10Application.class, args);
    }

    @Bean
    public CommandLineRunner hintRunner() {
        return args -> {
            logger.info("Application started successfully!");
            logger.info("Access the Form Validation page at: http://localhost:9090/SpringFormValidation/cust/save.do");
        };
    }
}