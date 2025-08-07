package New;
public class Employee {
    String id, name;
    int yob;

    public Employee(String id, String name, int yob) {
        this.id = id;
        this.name = name;
        this.yob = yob;
    }

    public void show() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("YOB: " + yob);

        String[] p = id.split("-");
        if (p.length == 3) {
            System.out.println("Year: " + p[0]);
            System.out.println("Desig: " + p[1]);
            System.out.println("No: " + p[2]);
        } else {
            System.out.println("Invalid ID format");
        }
    }
}
/*
Enter Id:
123
Enter Name:
vinay
Enter YOB:
2002
ID: 123
Name: vinay
YOB: 2002
Invalid ID format

Enter Id:
81-F-112
Enter Name:
Vinay
Enter YOB:
2002
ID: 81-F-112
Name: Vinay
YOB: 2002
Year: 81
Desig: F
No: 112
*/