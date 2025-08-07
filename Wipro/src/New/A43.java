package New;
import java.io.*;

public class A43 {
    public static void main(String[] args) {
        String fileName = "sample.txt"; // Make sure this file exists in your project folder

        try (BufferedReader br = new BufferedReader(new FileReader("batchmates.txt"))) {
            String line;
            System.out.println("File content:");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
/*
File content:
A
B
C
D
*/