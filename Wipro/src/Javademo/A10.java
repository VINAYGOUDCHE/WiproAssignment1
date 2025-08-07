package Javademo;
import java.util.Scanner;

public class A10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of eggs: ");
        int n = sc.nextInt();

        int g = n / 144;
        int r1 = n % 144;
        int d = r1 / 12;
        int r2 = r1 % 12;

        System.out.println("Your number of eggs is " + g + " gross, " + d + " dozen, and " + r2);
        
        sc.close();
    }
}
/*
Enter the number of eggs: 1000
Your number of eggs is 6 gross, 11 dozen, and 4
*/
