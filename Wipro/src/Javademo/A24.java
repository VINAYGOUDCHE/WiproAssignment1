package Javademo;
import java.util.Scanner;

public class A24 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] speeds = new int[5];
        int total = 0;

        System.out.println("Enter the speed of 5 bikers:");

        for (int i = 0; i < 5; i++) {
            System.out.print("Speed of biker " + (i + 1) + ": ");
            speeds[i] = sc.nextInt();
            total += speeds[i];
        }

        double average = total / 5.0;

        System.out.println("\nAverage speed: " + average);
        System.out.println("Qualifying bikers (speed > average):");

        for (int i = 0; i < 5; i++) {
            if (speeds[i] > average) {
                System.out.println("Biker " + (i + 1) + ": " + speeds[i]);
            }
        }

        sc.close();
    }
}
/*
Enter the speed of 5 bikers:
Speed of biker 1: 20
Speed of biker 2: 30
Speed of biker 3: 40
Speed of biker 4: 50
Speed of biker 5: 60

Average speed: 40.0
Qualifying bikers (speed > average):
Biker 4: 50
Biker 5: 60
*/