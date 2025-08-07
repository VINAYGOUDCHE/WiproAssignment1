package Javademo;
import java.util.Scanner;

class Shape {
    public void area(int side) {
        System.out.println("Area of square: " + (side * side));
    }

    public void area(int length, int breadth) {
        System.out.println("Area of rectangle: " + (length * breadth));
    }

    public void perimeter(int side) {
        System.out.println("Perimeter of square: " + (4 * side));
    }

    public void perimeter(int length, int breadth) {
        System.out.println("Perimeter of rectangle: " + (2 * (length + breadth)));
    }
}

public class A14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Shape s = new Shape();

        System.out.print("Enter side of square: ");
        int sq = sc.nextInt();

        System.out.print("Enter length of rectangle: ");
        int len = sc.nextInt();
        System.out.print("Enter breadth of rectangle: ");
        int br = sc.nextInt();

        s.area(sq);
        s.area(len, br);

        s.perimeter(sq);
        s.perimeter(len, br);

        sc.close();
    }
}
/*
Enter side of square: 5
Enter length of rectangle: 7
Enter breadth of rectangle: 8
Area of square: 25
Area of rectangle: 56
Perimeter of square: 20
Perimeter of rectangle: 30
*/
