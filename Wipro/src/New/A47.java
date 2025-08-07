package New;

import java.util.Scanner;

class InvalidSalaryException extends Exception {
    public InvalidSalaryException(String msg) {
        super(msg);
    }
}

class Staff2 {
    int id;
    String name;
    double sal;

    Staff2(int id, String name, double sal) {
        this.id = id;
        this.name = name;
        this.sal = sal;
    }
}

class StaffService {
    void validateSalary(double s) throws InvalidSalaryException {
        if (s < 0)
            throw new InvalidSalaryException("Invalid Salary: Salary cannot be negative.");
    }

    void processSalary(Staff2 s) throws InvalidSalaryException {
        validateSalary(s.sal);
        System.out.println("Salary is valid for: " + s.name);
    }

    void startProcess(Staff2 s) throws InvalidSalaryException {
        processSalary(s);
    }
}

public class A47 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Staff ID: ");
        int id = sc.nextInt();

        System.out.print("Enter Staff Name: ");
        sc.nextLine(); // consume leftover newline
        String name = sc.nextLine();

        System.out.print("Enter Staff Salary: ");
        double sal = sc.nextDouble();

        Staff2 s = new Staff2(id, name, sal);
        StaffService ss = new StaffService();

        try {
            ss.startProcess(s);
        } catch (InvalidSalaryException ex) {
            System.out.println("Exception caught: " + ex.getMessage());
        }

        sc.close();
    }
}
/*
Enter Staff ID: 191
Enter Staff Name: Ashok
Enter Staff Salary: 35000
Salary is valid for: Ashok

Enter Staff ID: 132
Enter Staff Name: Dileep
Enter Staff Salary: -45000
Exception caught: Invalid Salary: Salary cannot be negative.

*/