package com.springlab7.SpringLab7;

import java.util.Scanner;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        ProductService service = (ProductService) context.getBean("productService");
        ProductDaoImpl daoImpl = (ProductDaoImpl) context.getBean("productDaoImpl");
        daoImpl.initializeSampleData();

        int choice;
        do {
            System.out.println("\n*************************************************************************");
            System.out.println("1. Generate Bill by entering code and quantity");
            System.out.println("2. Exit");
            System.out.println("*************************************************************************");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    // 💡 Show available products before code entry
                    List<Product> productList = daoImpl.getAllProducts();
                    System.out.println("\n📦 Available Products:");
                    for (Product p : productList) {
                        System.out.println("Code: " + p.getProduct_code() + " | " + p.getProduct_name() +
                            " (" + p.getProduct_category() + ") - Rs." + p.getProduct_price());
                    }

                    int code = 0, qty = 0;
                    boolean validCode = false, validQty = false;

                    do {
                        System.out.print("\nEnter product code: ");
                        code = sc.nextInt();
                        if (!service.validateProductCode(code)) {
                            System.out.println("❌ Invalid product code — must be a 4-digit positive number");
                        } else {
                            validCode = true;
                        }
                    } while (!validCode);

                    do {
                        System.out.print("Enter quantity: ");
                        qty = sc.nextInt();
                        if (!service.validateQuantity(qty)) {
                            System.out.println("❌ Invalid quantity — must be greater than 0");
                        } else {
                            validQty = true;
                        }
                    } while (!validQty);

                    try {
                        Product p = service.getProductDetails(code);
                        System.out.println("\nProduct Name: " + p.getProduct_name());
                        System.out.println("Category: " + p.getProduct_category());
                        System.out.println("Description: " + p.getProduct_description());
                        System.out.println("Price (Rs): " + p.getProduct_price());
                        System.out.println("Quantity: " + qty);
                        double total = service.calculatePrice(qty, p.getProduct_price());
                        System.out.println("💰 Total Bill Amount: Rs." + total);
                    } catch (Exception e) {
                        System.out.println("⚠️ Product with code " + code + " not found.");
                    }
                    break;

                case 2:
                    System.out.println("👋 Thank you! Exiting...");
                    break;

                default:
                    System.out.println("⛔ Please enter only option 1 or 2");
            }

        } while (choice != 2);

        sc.close();
    }
}
/*

*************************************************************************
1. Generate Bill by entering code and quantity
2. Exit
*************************************************************************
Enter your choice: 1

📦 Available Products:
Code: 1001 | Washing Machine (electronics) - Rs.18000.0
Code: 1002 | LEDTV (electronics) - Rs.45000.0
Code: 1003 | Rice Bag (groceries) - Rs.1250.0

Enter product code: 1001
Enter quantity: 1

Product Name: Washing Machine
Category: electronics
Description: Semi Automatic
Price (Rs): 18000.0
Quantity: 1
💰 Total Bill Amount: Rs.18000.0

*************************************************************************
1. Generate Bill by entering code and quantity
2. Exit
*************************************************************************
Enter your choice: 
*/