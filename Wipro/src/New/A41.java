package New;

import java.util.*;

class BookStore {
    int bookId;
    String bookName;

    BookStore(int id, String name) {
        this.bookId = id;
        this.bookName = name;
    }

    public String toString() {
        return "ID: " + bookId + ", Name: " + bookName;
    }
}

public class A41 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<BookStore> list = new ArrayList<>();

        System.out.print("Enter number of books: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        for (int i = 0; i < n; i++) {
            System.out.print("Enter book ID: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter book name: ");
            String name = sc.nextLine();
            list.add(new BookStore(id, name));
        }

        System.out.println("\nSorted by Book Name:");
        list.sort(Comparator.comparing(b -> b.bookName.toLowerCase()));
        for (BookStore b : list) System.out.println(b);

        System.out.println("\nSorted by Book ID:");
        list.sort(Comparator.comparingInt(b -> b.bookId));
        for (BookStore b : list) System.out.println(b);

        sc.close();
    }
}
/*
Enter number of books: 4
Enter book ID: 101
Enter book name: Rich vs poor
Enter book ID: 103
Enter book name: Life secrets
Enter book ID: 105
Enter book name: Powerful spirits
Enter book ID: 102
Enter book name: Panchatantra

Sorted by Book Name:
ID: 103, Name: Life secrets
ID: 102, Name: Panchatantra
ID: 105, Name: Powerful spirits
ID: 101, Name: Rich vs poor

Sorted by Book ID:
ID: 101, Name: Rich vs poor
ID: 102, Name: Panchatantra
ID: 103, Name: Life secrets
ID: 105, Name: Powerful spirits
*/