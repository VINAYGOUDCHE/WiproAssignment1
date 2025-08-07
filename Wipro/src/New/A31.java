package New;
import java.util.Scanner;
import java.util.InputMismatchException;

public class A31 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
        	 System.out.println("Enter Number");
            int n = sc.nextInt(); // InputMismatchException if not an int
        } catch (InputMismatchException e) {
            System.out.println("InputMismatchException");
        }

        sc.nextLine(); // Clear buffer

        try {
        	System.out.println("Enter String");
            String s = sc.nextLine();
            System.out.println("Enter Number");
            int i = sc.nextInt();
            System.out.println(s.charAt(i)); // StringIndexOutOfBoundsException if index invalid
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("StringIndexOutOfBoundsException");
        }

        sc.close();
    }
}
/*
Enter Number
48
Enter String
Vinay
Enter Number
6
StringIndexOutOfBoundsException
*/