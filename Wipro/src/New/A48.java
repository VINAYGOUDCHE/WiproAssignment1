package New;
import java.util.*;

@FunctionalInterface
interface EmployeeProcessor {
    void process(Emp5 e);
}

class Emp5 {
    int id;
    String name;
    double sal;

    Emp5(int id, String name, double sal) {
        this.id = id;
        this.name = name;
        this.sal = sal;
    }
}

public class A48 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Emp5> list = new ArrayList<>();

        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter details of employee " + (i + 1));
            System.out.print("ID: ");
            int id = sc.nextInt();
            sc.nextLine(); // consume newline
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Salary: ");
            double sal = sc.nextDouble();

            list.add(new Emp5(id, name, sal));
        }

        EmployeeProcessor printDetails = e -> 
            System.out.println("Name: " + e.name + ", Salary: " + e.sal);

        EmployeeProcessor calcBonus = e -> 
            System.out.println("Bonus for " + e.name + ": " + (e.sal * 0.10));

        System.out.println("\n--- Employee Details ---");
        for (Emp5 e : list) {
            printDetails.process(e);
        }

        System.out.println("\n--- Bonus Details ---");
        for (Emp5 e : list) {
            calcBonus.process(e);
        }

        sc.close();
    }
}
/*
Enter number of employees: 3
Enter details of employee 1
ID: 101
Name: Raju
Salary: 37000
Enter details of employee 2
ID: 201
Name: Ravi
Salary: 49000
Enter details of employee 3
ID: 301
Name: Ramu
Salary: 57000

--- Employee Details ---
Name: Raju, Salary: 37000.0
Name: Ravi, Salary: 49000.0
Name: Ramu, Salary: 57000.0

--- Bonus Details ---
Bonus for Raju: 3700.0
Bonus for Ravi: 4900.0
Bonus for Ramu: 5700.0
*/