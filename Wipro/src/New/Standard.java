package New;
public class Standard {
    Student[] students = new Student[8];

    public void addStudent(int index, Student s) {
        students[index] = s;
    }

    // 1. Display roll no and name in ascending order of roll no
    public void displayByRollNo() {
        for (int i = 0; i < students.length - 1; i++) {
            for (int j = i + 1; j < students.length; j++) {
                if (students[i].getRollNo() > students[j].getRollNo()) {
                    Student temp = students[i];
                    students[i] = students[j];
                    students[j] = temp;
                }
            }
        }
        System.out.println("Students by Roll No:");
        for (Student s : students) {
            System.out.println("Roll No: " + s.getRollNo() + ", Name: " + s.getStudName());
        }
    }

    // 2. Student with highest percentage
    public void displayHighestPercentage() {
        Student top = students[0];
        for (int i = 1; i < students.length; i++) {
            if (students[i].getPercentage() > top.getPercentage()) {
                top = students[i];
            }
        }
        System.out.println("Highest Percentage:");
        System.out.println("Roll No: " + top.getRollNo() + ", Name: " + top.getStudName());
    }

    // 3. Student with highest maths marks
    public void displayHighestMaths() {
        Student top = students[0];
        for (int i = 1; i < students.length; i++) {
            if (students[i].getMarksInMaths() > top.getMarksInMaths()) {
                top = students[i];
            }
        }
        System.out.println("Highest Maths Marks:");
        System.out.println("Roll No: " + top.getRollNo() + ", Name: " + top.getStudName());
    }

    // 4. Ascending order of Maths + Science
    public void displayByMathsScience() {
        for (int i = 0; i < students.length - 1; i++) {
            for (int j = i + 1; j < students.length; j++) {
                int total1 = students[i].getMarksInMaths() + students[i].getMarksInScience();
                int total2 = students[j].getMarksInMaths() + students[j].getMarksInScience();
                if (total1 > total2) {
                    Student temp = students[i];
                    students[i] = students[j];
                    students[j] = temp;
                }
            }
        }
        System.out.println("Students by Maths + Science Total:");
        for (Student s : students) {
            int total = s.getMarksInMaths() + s.getMarksInScience();
            System.out.println("Roll No: " + s.getRollNo() + ", Name: " + s.getStudName() + ", Total: " + total);
        }
    }

    // 5. Display all with rank (descending order of total marks)
    public void displayWithRank() {
        for (int i = 0; i < students.length - 1; i++) {
            for (int j = i + 1; j < students.length; j++) {
                if (students[i].getTotalMarks() < students[j].getTotalMarks()) {
                    Student temp = students[i];
                    students[i] = students[j];
                    students[j] = temp;
                }
            }
        }

        System.out.println("Students with Rank:");
        for (int i = 0; i < students.length; i++) {
            Student s = students[i];
            System.out.println("Rank: " + (i + 1) + ", Roll No: " + s.getRollNo() + ", Name: " + s.getStudName()
                    + ", Total: " + s.getTotalMarks() + ", Percentage: " + String.format("%.2f", s.getPercentage()));
        }
    }
}
