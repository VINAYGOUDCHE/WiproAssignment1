package com.springlabs.lab12;

public class Book {
    private int bookid;
    private String bookname;
    private String author;
    private double price;

    // ✅ Default constructor (REQUIRED by Jackson)
    public Book() {}

    // ✅ Getters and setters (MUST be public)
    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}