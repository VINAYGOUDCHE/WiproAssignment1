package Javademo;
import java.util.Scanner;

class Calculator {
    void add(int a, int b) {
        System.out.println("Addition: " + (a + b));
    }

    void diff(int a, int b) {
        System.out.println("Subtraction: " + (a - b));
    }

    void mul(int a, int b) {
        System.out.println("Multiplication: " + (a * b));
    }

    void div(int a, int b) {
        if (b != 0) {
            System.out.println("Division: " + (a / b));
        } else {
            System.out.println("Division by zero is not allowed.");
        }
    }
}

public class A11{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator c = new Calculator();

        System.out.print("Enter first number: ");
        int x = sc.nextInt();

        System.out.print("Enter second number: ");
        int y = sc.nextInt();

        c.add(x, y);
        c.diff(x, y);
        c.mul(x, y);
        c.div(x, y);

        sc.close();
    }
}
/*
Enter first number: 5
Enter second number: 10
Addition: 15
Subtraction: -5
Multiplication: 50
Division: 0
*/
