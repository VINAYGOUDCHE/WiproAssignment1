package com.springlab1.SpringLab1;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.springlab1.SpringLab1")
@PropertySource("classpath:lab1.properties")
public class AppConfig {
}