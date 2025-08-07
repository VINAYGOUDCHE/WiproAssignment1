package New;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

class Emp7 {
    int id;
    String name, dept;
    double salary;

    Emp7(int id, String name, String dept, double salary) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.salary = salary;
    }

    public String toString() {
        return name + " - " + dept + " - Rs." + salary;
    }
}

public class A50 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Emp7> emps = Arrays.asList(
            new Emp7(101, "Ravi", "HR", 50000),
            new Emp7(102, "Priya", "IT", 60000),
            new Emp7(103, "Arun", "HR", 55000),
            new Emp7(104, "Kavya", "IT", 70000),
            new Emp7(105, "Divya", "Sales", 45000)
        );

        while (true) {
            System.out.println("\nChoose a query to execute (1-20, 101-103 for Challenges, 0 to exit):");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 0: return;
                case 1: emps.stream().map(e -> e.name).forEach(System.out::println); break;
                case 2: emps.stream().filter(e -> e.salary > 55000).forEach(System.out::println); break;
                case 3: System.out.println("HR count: " + emps.stream().filter(e -> e.dept.equals("HR")).count()); break;
                case 4: emps.stream().sorted(Comparator.comparingDouble(e -> -e.salary)).forEach(System.out::println); break;
                case 5: emps.stream().max(Comparator.comparingDouble(e -> e.salary)).ifPresent(System.out::println); break;
                case 6: System.out.println("Avg salary: " + emps.stream().mapToDouble(e -> e.salary).average().orElse(0)); break;
                case 7: System.out.println(emps.stream().map(e -> e.name).collect(Collectors.toList())); break;
                case 8: System.out.println(emps.stream().collect(Collectors.groupingBy(e -> e.dept))); break;
                case 9: System.out.println(emps.stream().collect(Collectors.groupingBy(e -> e.dept, Collectors.summingDouble(e -> e.salary)))); break;
                case 10: emps.stream().filter(e -> e.dept.equals("IT")).sorted(Comparator.comparingDouble(e -> e.salary)).map(e -> e.name).forEach(System.out::println); break;
                case 11: System.out.println("Any < 40000: " + emps.stream().anyMatch(e -> e.salary < 40000)); break;
                case 12: System.out.println(emps.stream().map(e -> e.name).collect(Collectors.joining(", "))); break;
                case 13: emps.stream().sorted(Comparator.comparingDouble(e -> -e.salary)).limit(2).forEach(System.out::println); break;
                case 14: emps.stream().skip(2).forEach(System.out::println); break;
                case 15: emps.stream().limit(3).map(e -> e.name).forEach(System.out::println); break;
                case 16: emps.stream().filter(e -> e.dept.equals("HR")).min(Comparator.comparingDouble(e -> e.salary)).ifPresent(System.out::println); break;
                case 17: System.out.println(emps.stream().collect(Collectors.partitioningBy(e -> e.salary > 55000))); break;
                case 18: System.out.println(emps.stream().collect(Collectors.groupingBy(e -> e.dept, Collectors.averagingDouble(e -> e.salary)))); break;
                case 19: emps.stream().sorted(Comparator.comparing(e -> e.name)).sorted(Comparator.comparingDouble(e -> e.salary)).forEach(System.out::println); break;
                case 20: System.out.println(emps.stream().collect(Collectors.toMap(e -> e.id, e -> e.name))); break;
                case 101: emps.stream().filter(e -> e.name.startsWith("D") && e.name.endsWith("a")).forEach(System.out::println); break;
                case 102: emps.stream().collect(Collectors.groupingBy(e -> e.dept)).entrySet().stream().filter(e -> e.getValue().size() > 1).forEach(e -> System.out.println(e.getKey() + ": " + e.getValue())); break;
                case 103: emps.stream().map(e -> e.salary).distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().ifPresent(s -> System.out.println("Second highest: " + s)); break;
                default: System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
/*

Choose a query to execute (1-20, 101-103 for Challenges, 0 to exit):
1
Ravi
Priya
Arun
Kavya
Divya

Choose a query to execute (1-20, 101-103 for Challenges, 0 to exit):
2
Priya - IT - Rs.60000.0
Kavya - IT - Rs.70000.0

Choose a query to execute (1-20, 101-103 for Challenges, 0 to exit):
3
HR count: 2

Choose a query to execute (1-20, 101-103 for Challenges, 0 to exit):
4
Kavya - IT - Rs.70000.0
Priya - IT - Rs.60000.0
Arun - HR - Rs.55000.0
Ravi - HR - Rs.50000.0
Divya - Sales - Rs.45000.0

Choose a query to execute (1-20, 101-103 for Challenges, 0 to exit):
5
Kavya - IT - Rs.70000.0

Choose a query to execute (1-20, 101-103 for Challenges, 0 to exit):
6
Avg salary: 56000.0

Choose a query to execute (1-20, 101-103 for Challenges, 0 to exit):
7
[Ravi, Priya, Arun, Kavya, Divya]

Choose a query to execute (1-20, 101-103 for Challenges, 0 to exit):
8
{Sales=[Divya - Sales - Rs.45000.0], HR=[Ravi - HR - Rs.50000.0, Arun - HR - Rs.55000.0], IT=[Priya - IT - Rs.60000.0, Kavya - IT - Rs.70000.0]}

Choose a query to execute (1-20, 101-103 for Challenges, 0 to exit):
9
{Sales=45000.0, HR=105000.0, IT=130000.0}

Choose a query to execute (1-20, 101-103 for Challenges, 0 to exit):
10
Priya
Kavya

Choose a query to execute (1-20, 101-103 for Challenges, 0 to exit):
11
Any < 40000: false

Choose a query to execute (1-20, 101-103 for Challenges, 0 to exit):
12
Ravi, Priya, Arun, Kavya, Divya

Choose a query to execute (1-20, 101-103 for Challenges, 0 to exit):
13
Kavya - IT - Rs.70000.0
Priya - IT - Rs.60000.0

Choose a query to execute (1-20, 101-103 for Challenges, 0 to exit):
14
Arun - HR - Rs.55000.0
Kavya - IT - Rs.70000.0
Divya - Sales - Rs.45000.0

Choose a query to execute (1-20, 101-103 for Challenges, 0 to exit):
15
Ravi
Priya
Arun

Choose a query to execute (1-20, 101-103 for Challenges, 0 to exit):
16
Ravi - HR - Rs.50000.0

Choose a query to execute (1-20, 101-103 for Challenges, 0 to exit):
17
{false=[Ravi - HR - Rs.50000.0, Arun - HR - Rs.55000.0, Divya - Sales - Rs.45000.0], true=[Priya - IT - Rs.60000.0, Kavya - IT - Rs.70000.0]}

Choose a query to execute (1-20, 101-103 for Challenges, 0 to exit):
18
{Sales=45000.0, HR=52500.0, IT=65000.0}

Choose a query to execute (1-20, 101-103 for Challenges, 0 to exit):
19
Divya - Sales - Rs.45000.0
Ravi - HR - Rs.50000.0
Arun - HR - Rs.55000.0
Priya - IT - Rs.60000.0
Kavya - IT - Rs.70000.0

Choose a query to execute (1-20, 101-103 for Challenges, 0 to exit):
20
{101=Ravi, 102=Priya, 103=Arun, 104=Kavya, 105=Divya}

Choose a query to execute (1-20, 101-103 for Challenges, 0 to exit):
101
Divya - Sales - Rs.45000.0

Choose a query to execute (1-20, 101-103 for Challenges, 0 to exit):
102
HR: [Ravi - HR - Rs.50000.0, Arun - HR - Rs.55000.0]
IT: [Priya - IT - Rs.60000.0, Kavya - IT - Rs.70000.0]

Choose a query to execute (1-20, 101-103 for Challenges, 0 to exit):
103
Second highest: 60000.0

Choose a query to execute (1-20, 101-103 for Challenges, 0 to exit):
104
Invalid choice. Try again.

Choose a query to execute (1-20, 101-103 for Challenges, 0 to exit):
105
Invalid choice. Try again.

Choose a query to execute (1-20, 101-103 for Challenges, 0 to exit):
0
*/