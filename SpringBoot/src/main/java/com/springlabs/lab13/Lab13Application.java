package com.springlabs.lab13;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.springlabs.lab13")
@EnableJpaRepositories(basePackages = "com.springlabs.lab13")
public class Lab13Application {

    private static final Logger logger = LoggerFactory.getLogger(Lab13Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Lab13Application.class, args);
    }

    @Bean
    public CommandLineRunner greetingRunner() {
        return args -> {
            logger.info("Application started successfully!");
            logger.info("Access your API at: http://localhost:8080/api/user");
        };
    }
}