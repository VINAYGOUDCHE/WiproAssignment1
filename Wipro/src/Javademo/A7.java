package Javademo;
import java.util.Scanner;
public class A7 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter classes held: ");
        int ch = sc.nextInt();

        System.out.print("Enter classes attended: ");
        int ca = sc.nextInt();

        if (ca > ch) {
            System.out.println("Invalid input.");
        }

        double ap = calcAP(ch, ca);
        System.out.printf("Attendance percentage: %.2f%%%n", ap);

        String result = checkEligibility(ap);
        System.out.println(result);

        sc.close();
    }

    static double calcAP(int ch, int ca) {
        return ((double) ca / ch) * 100;
    }

    static String checkEligibility(double ap) {
        return ap >= 70 ? "Allowed to sit in exam." : "Not allowed to sit in exam.";
    }
}
/*
Enter classes held: 20
Enter classes attended: 10
Attendance percentage: 50.00%
Not allowed to sit in exam.

Enter classes held: 20
Enter classes attended: 15
Attendance percentage: 75.00%
Allowed to sit in exam.
*/