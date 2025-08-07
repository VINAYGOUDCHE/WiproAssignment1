package com.springlab9.SpringLab9;

import java.time.LocalDate;

public class Purchase {
    private int purchaseId;
    private LocalDate purchaseDate;
    private Product product;

    public Purchase(int purchaseId, String purchaseDate, Product product) {
        this.purchaseId = purchaseId;
        this.purchaseDate = LocalDate.parse(purchaseDate); // Converts String to LocalDate
        this.product = product;
    }

    public void displayPurchaseDetails() {
        System.out.println("Purchase ID: " + purchaseId);
        System.out.println("Purchase Date: " + purchaseDate);
        System.out.println(product.getDetails());
    }
}