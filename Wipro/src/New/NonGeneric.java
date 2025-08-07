package New;
import java.util.*;

class NonGenericLibrary {
    List<Object> items = new ArrayList<>();

    void add(Object item) {
        items.add(item);
    }

    List<Object> getAll() {
        return items;
    }
}

public class NonGeneric {
    public static void main(String[] args) {
        NonGenericLibrary lib = new NonGenericLibrary();

        lib.add(new Book("Python Guide"));
        lib.add(new Video("Data Structures"));
        lib.add(new Newspaper("Daily News"));

        for (Object o : lib.getAll()) {
            System.out.println(o);
        }
    }
}
/*
Book: Python Guide
Video: Data Structures
Newspaper: Daily News
*/