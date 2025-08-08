package com.springlabs.lab2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Lab2Application {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Lab2Application.class, args);
        PropertyReader reader = context.getBean(PropertyReader.class);
        reader.showValues();
    }
}