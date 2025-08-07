package New;

import java.util.Scanner;

public class A28 {

    public static boolean isOdd(int num) {
        return num % 2 != 0;
    }

    public static boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public static boolean isPalindrome(int num) {
        int original = num;
        int reversed = 0;

        while (num != 0) {
            int digit = num % 10;
            reversed = reversed * 10 + digit;
            num /= 10;
        }

        return original == reversed;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = scanner.nextInt();

        System.out.println("Is Odd? " + isOdd(num));
        System.out.println("Is Prime? " + isPrime(num));
        System.out.println("Is Palindrome? " + isPalindrome(num));
        scanner.close();
    }
}
/*
Enter a number: 121
Is Odd? true
Is Prime? false
Is Palindrome? true
*/