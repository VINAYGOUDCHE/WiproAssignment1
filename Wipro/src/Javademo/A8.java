package Javademo;
import java.util.*;

public class A8 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        System.out.print("Enter classes held: ");
        int ch = sc.nextInt();

        System.out.print("Enter classes attended: ");
        int ca = sc.nextInt();

        if (ca > ch) {
            System.out.println("Invalid input.");
        }

        sc.nextLine(); 

        System.out.print("Do you have medical cause? (Y/N): ");
        String mc = sc.nextLine().toUpperCase();

        double ap = calcAP(ch, ca);
        System.out.printf("Attendance percentage: %.2f%%%n", ap);

        String result;
        if (mc.equals("Y")) {
            result = "Allowed to sit in exam due to medical cause.";
        } else if (ap >= 70) {
            result = "Allowed to sit in exam.";
        } else {
            result = "Not allowed to sit in exam.";
        }

        System.out.println(result);

        sc.close();
	}
	static double calcAP(int ch, int ca) {
        return ((double) ca / ch) * 100;

	}

}
/*
 Enter classes held: 20
Enter classes attended: 10
Do you have medical cause? (Y/N): y
Attendance percentage: 50.00%
Allowed to sit in exam due to medical cause.
*/
