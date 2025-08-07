package New;
import java.util.Optional;
import java.util.Scanner;

class FieldMissingException extends Exception {
    public FieldMissingException(String msg) {
        super(msg);
    }
}

class emp6 {
    private int id;
    private String name;
    private Optional<String> email;
    private Optional<String> dept;

    emp6(int id, String name, String email, String dept) {
        this.id = id;
        this.name = name;
        this.email = Optional.ofNullable(email);
        this.dept = Optional.ofNullable(dept);
    }

    public void show() throws FieldMissingException {
        if (name == null || name.isEmpty()) {
            throw new FieldMissingException("Name cannot be empty.");
        }

        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email.orElse("Not Provided"));
        System.out.println("Department: " + dept.orElse("General"));
    }
}

public class A49 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Email (optional): ");
        String email = sc.nextLine();
        if (email.isEmpty()) email = null;

        System.out.print("Enter Department (optional): ");
        String dept = sc.nextLine();
        if (dept.isEmpty()) dept = null;

        emp6 e = new emp6(id, name, email, dept);

        try {
            System.out.println("\n--- Employee Details ---");
            e.show();
        } catch (FieldMissingException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        sc.close();
    }
}
/*
Enter ID: 101
Enter Name: Vishnu
Enter Email (optional): 
Enter Department (optional): 

--- Employee Details ---
ID: 101
Name: Vishnu
Email: Not Provided
Department: General

Enter ID: 201
Enter Name: Vardhan
Enter Email (optional): Vardhan@gmail.com
Enter Department (optional): Testing

--- Employee Details ---
ID: 201
Name: Vardhan
Email: Vardhan@gmail.com
Department: Testing
*/