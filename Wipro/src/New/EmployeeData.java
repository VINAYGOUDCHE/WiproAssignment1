package New;
import java.io.*;
import java.util.*;

public class EmployeeData {
    static class Employee1 implements Serializable {
        int emp_id;
        String emp_name;
        transient double emp_sal;

        Employee1(int id, String name, double sal) {
            emp_id = id;
            emp_name = name;
            emp_sal = sal;
        }

        void show() {
            System.out.println("ID: " + emp_id);
            System.out.println("Name: " + emp_name);
            System.out.println("Salary: " + emp_sal);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Salary: ");
        double sal = sc.nextDouble();

        Employee1 e = new Employee1(id, name, sal);

        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("emp.ser"));
            out.writeObject(e);
            out.close();

            ObjectInputStream in = new ObjectInputStream(new FileInputStream("emp.ser"));
            Employee1 e2 = (Employee1) in.readObject();
            in.close();

            System.out.println("\nDeserialized Employee:");
            e2.show();

        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        }

        sc.close();
    }
}
/*
Enter ID: 1
Enter Name: abc
Enter Salary: 23000

Deserialized Employee:
ID: 1
Name: abc
Salary: 0.0

Enter ID: 1
Enter Name: bcd
Enter Salary: 56000

Deserialized Employee:
ID: 1
Name: bcd
Salary: 0.0

*/