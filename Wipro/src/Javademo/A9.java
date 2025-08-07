package Javademo;
import java.util.Scanner;
public class A9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double total = 0;

        while (true) {
            System.out.print("Enter product number (1-3) or 0 to exit: ");
            int pn = sc.nextInt();

            if (pn == 0) {
                break;
            }

            System.out.print("Enter quantity sold: ");
            int qty = sc.nextInt();

            double price = getPrice(pn);
            if (price == -1) {
                System.out.println("Invalid product number.");
                continue;
            }

            double amount = price * qty;
            System.out.printf("Product %d: %.2f x %d = %.2f%n", pn, price, qty, amount);

            total += amount;
        }

        System.out.printf("Total retail value: %.2f%n", total);

        sc.close();
    }

    static double getPrice(int pn) {
        switch (pn) {
            case 1:
                return 22.50;
            case 2:
                return 44.50;
            case 3:
                return 9.98;
            default:
                return -1;
        }
    }
}
/*
Enter product number (1-3) or 0 to exit: 1
Enter quantity sold: 20
Product 1: 22.50 x 20 = 450.00
Enter product number (1-3) or 0 to exit: 2
Enter quantity sold: 10
Product 2: 44.50 x 10 = 445.00
Enter product number (1-3) or 0 to exit: 3
Enter quantity sold: 1
Product 3: 9.98 x 1 = 9.98
Enter product number (1-3) or 0 to exit: 0
Total retail value: 904.98
*/