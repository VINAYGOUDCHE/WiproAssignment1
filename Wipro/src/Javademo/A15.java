package Javademo;
import java.util.Scanner;

public class A15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];

        System.out.println("Enter 10 integers:");
        for (int i = 0; i < 10; i++) {
            arr[i] = sc.nextInt();
        }

        boolean[] counted = new boolean[10];

        System.out.println("\nOccurrences of each element:");
        for (int i = 0; i < 10; i++) {
            if (!counted[i]) {
                int count = 1;
                for (int j = i + 1; j < 10; j++) {
                    if (arr[i] == arr[j]) {
                        count++;
                        counted[j] = true;
                    }
                }
                System.out.println(arr[i] + " occurs " + count + " time(s)");
            }
        }

        sc.close();
    }
}
/*
Enter 10 integers:
2
3
7
8
-9
10
12
16
-25
29

Occurrences of each element:
2 occurs 1 time(s)
3 occurs 1 time(s)
7 occurs 1 time(s)
8 occurs 1 time(s)
-9 occurs 1 time(s)
10 occurs 1 time(s)
12 occurs 1 time(s)
16 occurs 1 time(s)
-25 occurs 1 time(s)
29 occurs 1 time(s)
*/
/*
Enter 10 integers:
3
4
5
-2
-9
-4
5
-4
-10
-9

Occurrences of each element:
3 occurs 1 time(s)
4 occurs 1 time(s)
5 occurs 2 time(s)
-2 occurs 1 time(s)
-9 occurs 2 time(s)
-4 occurs 2 time(s)
-10 occurs 1 time(s)
*/