package New;
import java.util.Scanner;

class InvalidEmployeeCode extends Exception {
    public InvalidEmployeeCode(String msg) {
        super(msg);
    }
}

class Employe {
    String code, name;

    public Employe(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public void show() {
        System.out.println("Code: " + code);
        System.out.println("Name: " + name);
    }
}

public class A35 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter code: ");
        String code = sc.nextLine();

        System.out.print("Enter name: ");
        String name = sc.nextLine();

        try {
            if (!code.matches("\\d{2}-[FS]-\\d{3}")) {
                throw new InvalidEmployeeCode("InvalidEmployeeCode");
            }

            Employe e = new Employe(code, name);
            e.show();

        } catch (InvalidEmployeeCode ex) {
            System.out.println("InvalidEmployeeCode");
        }

        sc.close();
    }
}
/*
Enter code: 81-F-112
Enter name: Raju
Code: 81-F-112
Name: Raju
*/