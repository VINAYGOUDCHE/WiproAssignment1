package Javademo;
import java.util.Scanner;

public class A25 {

    public static boolean isValid(double a, double b, double c) {
        return (a + b > c) && (a + c > b) && (b + c > a);
    }

    public static double perimeter(double a, double b, double c) {
        return a + b + c;
    }

    public static double area(double a, double b, double c) {
        double s = (a + b + c) / 2;
        double ar = Math.sqrt(s * (s - a) * (s - b) * (s - c));
        return ar;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Enter side a (or -1 to exit): ");
            double a = sc.nextDouble();

            if (a == -1) {
                System.out.println("Bye");
                break;
            }

            System.out.print("Enter side b: ");
            double b = sc.nextDouble();

            System.out.print("Enter side c: ");
            double c = sc.nextDouble();

            if (isValid(a, b, c)) {
                double per = perimeter(a, b, c);
                double ar = area(a, b, c);
                System.out.println("Perimeter: " + per);
                System.out.println("Area: " + ar);
            } else {
                System.out.println("The input is invalid.");
            }
        }

        sc.close();
    }
}
/*
Enter side a (or -1 to exit): 3
Enter side b: 4
Enter side c: 5
Perimeter: 12.0
Area: 6.0
Enter side a (or -1 to exit): -1
Bye
*/