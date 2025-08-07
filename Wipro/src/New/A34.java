package New;
import java.util.Scanner;

public class A34 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Id:");
        String id = sc.nextLine();
        System.out.println("Enter Name:");
        String name = sc.nextLine();
        System.out.println("Enter YOB:");
        int yob = sc.nextInt();

        Employee e = new Employee(id, name, yob);
        e.show();

        sc.close();
    }
}
