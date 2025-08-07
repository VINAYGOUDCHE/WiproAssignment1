package Javademo;
import java.util.Scanner;
public class A5 {

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);

	        System.out.print("Enter your salary: ");
	        int salary = sc.nextInt();

	        System.out.print("Enter your year of service: ");
	        int yearOfService = sc.nextInt();

	        double bonus = 0;
	        if (yearOfService > 6) {
	            bonus = salary * 0.10;
	        }

	        System.out.println("Your net bonus amount is: " + bonus);

	        sc.close();

	}

}
/*
Enter your salary: 1000
Enter your year of service: 7
Your net bonus amount is: 100.0
*/