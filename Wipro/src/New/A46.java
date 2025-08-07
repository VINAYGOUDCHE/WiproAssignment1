package New;
import java.util.*;

class Staff {
    int id;
    String name;
    double sal;

    Staff(int id, String name, double sal) {
        this.id = id;
        this.name = name;
        this.sal = sal;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Salary: " + sal;
    }
}

class Repository<T, ID> {
    private Map<ID, T> data = new HashMap<>();

    void save(ID id, T entity) {
        data.put(id, entity);
    }

    T findById(ID id) {
        return data.get(id);
    }

    List<T> findAll() {
        return new ArrayList<>(data.values());
    }

    void deleteById(ID id) {
        data.remove(id);
    }
}

public class A46 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Repository<Staff, Integer> repo = new Repository<>();

        System.out.print("Enter number of staff: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for staff " + (i + 1));
            System.out.print("ID: ");
            int id = sc.nextInt();
            sc.nextLine(); // consume newline

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Salary: ");
            double sal = sc.nextDouble();

            repo.save(id, new Staff(id, name, sal));
        }

        System.out.println("\nAll Staff:");
        for (Staff s : repo.findAll()) {
            System.out.println(s);
        }

        System.out.print("\nEnter ID to find staff: ");
        int fid = sc.nextInt();
        Staff found = repo.findById(fid);
        if (found != null) {
            System.out.println("Found: " + found);
        } else {
            System.out.println("Staff not found.");
        }

        System.out.print("\nEnter ID to delete staff: ");
        int did = sc.nextInt();
        repo.deleteById(did);

        System.out.println("\nAfter deletion:");
        for (Staff s : repo.findAll()) {
            System.out.println(s);
        }

        sc.close();
    }
}
/*
Enter number of staff: 3

Enter details for staff 1
ID: 101
Name: Ashok
Salary: 35000

Enter details for staff 2
ID: 201
Name: Srinu
Salary: 45000

Enter details for staff 3
ID: 301
Name: Shankar
Salary: 75000

All Staff:
ID: 101, Name: Ashok, Salary: 35000.0
ID: 201, Name: Srinu, Salary: 45000.0
ID: 301, Name: Shankar, Salary: 75000.0

Enter ID to find staff: 401
Staff not found.

Enter ID to delete staff: 201

After deletion:
ID: 101, Name: Ashok, Salary: 35000.0
ID: 301, Name: Shankar, Salary: 75000.0
*/