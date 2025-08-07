package New;
import java.util.*;

class Library<T> {
    List<T> items = new ArrayList<>();

    void add(T item) {
        items.add(item);
    }

    List<T> getAll() {
        return items;
    }
}

class Book {
    String title;
    Book(String t) { title = t; }
    public String toString() { return "Book: " + title; }
}

class Video {
    String title;
    Video(String t) { title = t; }
    public String toString() { return "Video: " + title; }
}

class Newspaper {
    String name;
    Newspaper(String n) { name = n; }
    public String toString() { return "Newspaper: " + name; }
}

public class Generic {
    public static void main(String[] args) {
        Library<Book> bookLib = new Library<>();
        Library<Video> videoLib = new Library<>();
        Library<Newspaper> newsLib = new Library<>();

        bookLib.add(new Book("Java Basics"));
        videoLib.add(new Video("OOP Concepts"));
        newsLib.add(new Newspaper("The Times"));

        for (Book b : bookLib.getAll()) System.out.println(b);
        for (Video v : videoLib.getAll()) System.out.println(v);
        for (Newspaper n : newsLib.getAll()) System.out.println(n);
    }
}
/*
Book: Java Basics
Video: OOP Concepts
Newspaper: The Times
*/