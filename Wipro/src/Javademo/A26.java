package Javademo;
import java.util.Scanner;
import java.util.LinkedHashSet;

public class A26 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Sample input: 2 3 54 1 6 7 7
        System.out.println("Enter the size of the array:");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter " + n + " integers:");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        LinkedHashSet<Integer> unique = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {
            unique.add(arr[i]);
        }

        int sumEven = 0;

        for (int num : unique) {
            if (num % 2 == 0) {
                sumEven += num;
            }
        }

        System.out.println("Sum of even numbers after removing duplicates: " + sumEven);

        sc.close();
    }
}
/*
Enter the size of the array:
7
Enter 7 integers:
2
3
4
3
3
2
6
Sum of even numbers after removing duplicates: 12
*/