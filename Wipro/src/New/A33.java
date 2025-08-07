package New;
import java.util.Scanner;

public class A33 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Id");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Name");
        String name = sc.nextLine();
        System.out.println("Enter Designation");
        String desig = sc.nextLine();
        System.out.println("Enter Salary");
        double sal = sc.nextDouble();

        try {
            Emp e = new Emp(id, name, desig, sal);
            e.printDet();
        } catch (LowSal e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
/*
Enter Id
1
Enter Name
Nithin
Enter Designation
hr
Enter Salary
25000
Error: Basic salary must be >= 50000.

Enter Id
1
Enter Name
Abc
Enter Designation
manager
Enter Salary
52000
ID: 1
Name: Abc
Desig: manager
Basic: 52000.0
HRA: 5200.0
*/