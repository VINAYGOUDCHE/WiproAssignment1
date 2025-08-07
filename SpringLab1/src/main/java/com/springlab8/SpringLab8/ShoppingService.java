package com.springlab8.SpringLab8;

public class ShoppingService {

    public void addToCart(String item) {
        System.out.println("Item added to cart: " + item);
    }

    public void makePayment(double amount) {
        System.out.println("Payment of Rs." + amount + " processed.");
    }

    public void placeOrder() {
        System.out.println("Order placed successfully!");
        // Uncomment this to simulate an exception and test @AfterThrowing
        // throw new RuntimeException("Order service unavailable");
    }
}