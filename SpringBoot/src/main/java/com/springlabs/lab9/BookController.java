package com.springlabs.lab9;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Arrays;
import java.util.List;

@RestController
public class BookController {

    @GetMapping("/bookXYZ")
    public BookList getBooks() {
        List<Book> bookList = Arrays.asList(
            new Book(101, "Java Tutorials", "Krishna"),
            new Book(102, "Spring Tutorials", "Mahesh"),
            new Book(103, "Angular Tutorials", "Shiva")
        );
        return new BookList(bookList);
    }
}