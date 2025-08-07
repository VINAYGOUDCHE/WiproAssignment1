package New;
import java.io.*;
import java.util.*;

public class A37 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        File f = new File("batchmates.txt");

        try {
            FileWriter fw = new FileWriter(f);

            System.out.print("Enter number of batchmates: ");
            int n = sc.nextInt();
            sc.nextLine(); // consume newline

            for (int i = 1; i <= n; i++) {
                System.out.print("Enter name " + i + ": ");
                String name = sc.nextLine();
                fw.write(name + "\n");
            }

            fw.close();

            System.out.println("\nBatchmates list:");
            Scanner fr = new Scanner(f);
            while (fr.hasNextLine()) {
                System.out.println(fr.nextLine());
            }
            fr.close();

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
/*
Enter number of batchmates: 4
Enter name 1: A
Enter name 2: B
Enter name 3: C
Enter name 4: D

Batchmates list:
A
B
C
D
*/