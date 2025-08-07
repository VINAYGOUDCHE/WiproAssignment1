package com.springlab1.SpringLab1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        CredentialReader reader = context.getBean(CredentialReader.class);
        reader.printDetails();
    }
}