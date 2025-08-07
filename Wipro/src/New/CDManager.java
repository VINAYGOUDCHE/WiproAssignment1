package New;
import java.util.*;

class CD implements Comparable<CD> {
    String title;
    String singer;

    CD(String title, String singer) {
        this.title = title;
        this.singer = singer;
    }

    public int compareTo(CD other) {
        return this.singer.compareToIgnoreCase(other.singer);
    }

    public String toString() {
        return "Title: " + title + ", Singer: " + singer;
    }
}

public class CDManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<CD> cds = new ArrayList<>();

        System.out.print("Enter number of CDs: ");
        int n = sc.nextInt();
        sc.nextLine();  // consume leftover newline

        for (int i = 0; i < n; i++) {
            System.out.print("Enter CD Title: ");
            String title = sc.nextLine();
            System.out.print("Enter Singer Name: ");
            String singer = sc.nextLine();
            cds.add(new CD(title, singer));
        }

        Collections.sort(cds);

        System.out.println("\nSorted CDs by Singer Name:");
        for (CD cd : cds) {
            System.out.println(cd);
        }

        sc.close();
    }
}
/*
Enter number of CDs: 3
Enter CD Title: Fidaa
Enter Singer Name: AR
Enter CD Title: Dasara
Enter Singer Name: Rahul
Enter CD Title: Saalar
Enter Singer Name: Taman

Sorted CDs by Singer Name:
Title: Fidaa, Singer: AR
Title: Dasara, Singer: Rahul
Title: Saalar, Singer: Taman
*/