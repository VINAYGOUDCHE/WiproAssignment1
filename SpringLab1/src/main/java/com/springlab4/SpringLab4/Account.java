package com.springlab4.SpringLab4;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Account {

    @Value("${account.number}")
    private long number;

    @Value("${account.holder}")
    private String holder;

    @Value("${account.balance}")
    private double balance;

    @Value("${account.type}")
    private String type;

    public void display() {
        System.out.println("Account No: " + number);
        System.out.println("Holder: " + holder);
        System.out.println("Balance: ₹" + balance);
        System.out.println("Type: " + type);
    }
}