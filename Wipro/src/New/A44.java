package New;
import java.util.*;

class Employee2 {
    int id;
    String name;
    double sal;

    Employee2(int id, String name, double sal) {
        this.id = id;
        this.name = name;
        this.sal = sal;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Salary: " + sal;
    }
}

public class A44 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Employee2> list = new ArrayList<>();

        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        for (int i = 0; i < n; i++) {
            System.out.print("Enter ID: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Salary: ");
            double sal = sc.nextDouble();
            sc.nextLine();
            list.add(new Employee2(id, name, sal));
        }

        System.out.println("\nSorted by Salary (Descending):");
        list.sort(Comparator.comparingDouble((Employee2 e) -> e.sal).reversed());
        for (Employee2 e : list) System.out.println(e);

        System.out.println("\nSorted by Name (Alphabetical):");
        list.sort((e1, e2) -> e1.name.compareToIgnoreCase(e2.name));
        for (Employee2 e : list) System.out.println(e);

        sc.close();
    }
}
/*
Enter number of employees: 3
Enter ID: 101
Enter Name: tharun
Enter Salary: 23000
Enter ID: 201
Enter Name: Hari
Enter Salary: 54000
Enter ID: 301
Enter Name: Sai
Enter Salary: 35000

Sorted by Salary (Descending):
ID: 201, Name: Hari, Salary: 54000.0
ID: 301, Name: Sai, Salary: 35000.0
ID: 101, Name: tharun, Salary: 23000.0

Sorted by Name (Alphabetical):
ID: 201, Name: Hari, Salary: 54000.0
ID: 301, Name: Sai, Salary: 35000.0
ID: 101, Name: tharun, Salary: 23000.0
*/