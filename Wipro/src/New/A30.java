package New;
import java.util.Scanner;

@FunctionalInterface
interface Short {
    double minimum3(double a, double b, double c);
}

public class A30 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double num1 = sc.nextDouble();
        double num2 = sc.nextDouble();
        double num3 = sc.nextDouble();

        Short minFunc = (a, b, c) -> Math.min(Math.min(a, b), c);

        System.out.println("Smallest value: " + minFunc.minimum3(num1, num2, num3));

        sc.close();
    }
}
/*
4
5
6
Smallest value: 4.0
*/