package New;
import java.util.*;
import java.util.stream.Collectors;

class Student1 {
    int id;
    String name;
    String dept;

    Student1(int id, String name, String dept) {
        this.id = id;
        this.name = name;
        this.dept = dept;
    }

    public String toString() {
        return name;
    }
}

public class A45 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Student1> list = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter ID: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Department: ");
            String dept = sc.nextLine();

            list.add(new Student1(id, name, dept));
        }

        Map<String, List<Student1>> grouped = list.stream()
                .collect(Collectors.groupingBy(s -> s.dept));

        System.out.println("\nGrouped Students by Department:");
        for (String d : grouped.keySet()) {
            System.out.println("Department: " + d);
            for (Student1 s : grouped.get(d)) {
                System.out.println(" - " + s.name);
            }
        }

        sc.close();
    }
}
/*
Enter number of students: 3
Enter ID: 12
Enter Name: Vinay
Enter Department: CSE
Enter ID: 13
Enter Name: Nikhil
Enter Department: ECE
Enter ID: 14
Enter Name: Sathwik
Enter Department: EEE

Grouped Students by Department:
Department: EEE
 - Sathwik
Department: CSE
 - Vinay
Department: ECE
 - Nikhil
*/