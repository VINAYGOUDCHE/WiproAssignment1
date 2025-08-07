package com.springlab8.SpringLab8;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ShoppingService service = (ShoppingService) context.getBean("shoppingService");

        service.addToCart("Laptop");
        service.makePayment(55000);
        service.placeOrder();
    }
}