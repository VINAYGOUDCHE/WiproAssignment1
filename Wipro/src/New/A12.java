package New;
import java.util.Scanner;

public class A12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Standard std = new Standard();

        for (int i = 0; i < 8; i++) {
            Student s = new Student();

            System.out.println("Enter details for Student " + (i + 1));
            System.out.print("Name: ");
            s.setStudName(sc.nextLine());

            System.out.print("Marks in English: ");
            s.setMarksInEng(sc.nextInt());

            System.out.print("Marks in Maths: ");
            s.setMarksInMaths(sc.nextInt());

            System.out.print("Marks in Science: ");
            s.setMarksInScience(sc.nextInt());
            sc.nextLine(); // consume newline

            std.addStudent(i, s);
            System.out.println();
        }

        std.displayByRollNo();
        System.out.println();
        std.displayHighestPercentage();
        System.out.println();
        std.displayHighestMaths();
        System.out.println();
        std.displayByMathsScience();
        System.out.println();
        std.displayWithRank();

        sc.close();
    }
}
/*
Enter details for Student 1
Name: a
Marks in English: 75
Marks in Maths: 87
Marks in Science: 84

Enter details for Student 2
Name: b
Marks in English: 94
Marks in Maths: 85
Marks in Science: 93

Enter details for Student 3
Name: 88
Marks in English: 82
Marks in Maths: 81
Marks in Science: 88

Enter details for Student 4
Name: d
Marks in English: 76
Marks in Maths: 65
Marks in Science: 74

Enter details for Student 5
Name: e
Marks in English: 66
Marks in Maths: 75
Marks in Science: 56

Enter details for Student 6
Name: f
Marks in English: 78
Marks in Maths: 81
Marks in Science: 79

Enter details for Student 7
Name: g
Marks in English: 92
Marks in Maths: 85
Marks in Science: 89

Enter details for Student 8
Name: h
Marks in English: 72
Marks in Maths: 69
Marks in Science: 75

Students by Roll No:
Roll No: 1, Name: a
Roll No: 2, Name: b
Roll No: 3, Name: 88
Roll No: 4, Name: d
Roll No: 5, Name: e
Roll No: 6, Name: f
Roll No: 7, Name: g
Roll No: 8, Name: h

Highest Percentage:
Roll No: 2, Name: b

Highest Maths Marks:
Roll No: 1, Name: a

Students by Maths + Science Total:
Roll No: 5, Name: e, Total: 131
Roll No: 4, Name: d, Total: 139
Roll No: 8, Name: h, Total: 144
Roll No: 6, Name: f, Total: 160
Roll No: 3, Name: 88, Total: 169
Roll No: 1, Name: a, Total: 171
Roll No: 7, Name: g, Total: 174
Roll No: 2, Name: b, Total: 178

Students with Rank:
Rank: 1, Roll No: 2, Name: b, Total: 272, Percentage: 90.67
Rank: 2, Roll No: 7, Name: g, Total: 266, Percentage: 88.67
Rank: 3, Roll No: 3, Name: 88, Total: 251, Percentage: 83.67
Rank: 4, Roll No: 1, Name: a, Total: 246, Percentage: 82.00
Rank: 5, Roll No: 6, Name: f, Total: 238, Percentage: 79.33
Rank: 6, Roll No: 8, Name: h, Total: 216, Percentage: 72.00
Rank: 7, Roll No: 4, Name: d, Total: 215, Percentage: 71.67
Rank: 8, Roll No: 5, Name: e, Total: 197, Percentage: 65.67
*/