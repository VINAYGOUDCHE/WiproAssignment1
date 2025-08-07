package com.springlab3.SpringLab3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Freshman student = context.getBean("freshman", Freshman.class);
        System.out.println("Name: " + student.getName());
        System.out.println("Room: " + student.getRoom().getLocation());
    }
}