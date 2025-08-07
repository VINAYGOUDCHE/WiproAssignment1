package New;

import java.util.Scanner;
import java.util.NoSuchElementException;

public class A29 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regNo = scanner.nextLine();
        String mobile = scanner.nextLine();

        try {
            if (regNo.length() != 9) {
                throw new IllegalArgumentException();
            }

            if (!regNo.matches("[a-zA-Z0-9]+")) {
                throw new NoSuchElementException();
            }

            if (mobile.length() != 10) {
                throw new IllegalArgumentException();
            }

            if (!mobile.matches("\\d+")) {
                throw new NumberFormatException();
            }

            System.out.println("valid");

        } catch (NumberFormatException | NoSuchElementException e) {
            System.out.println("invalid");
        } catch (IllegalArgumentException e) {
            System.out.println("invalid");
        }


        scanner.close();
    }
}
/*
20wj1a6956
8309431302
invalid

Abcdefghi
8309431302
valid
*/