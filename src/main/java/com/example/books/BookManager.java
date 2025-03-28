package com.example.books;

import java.util.ArrayList;
import java.util.List;

public class BookManager {

    private static BookManager bookManager;
    List<Book> books;

    private BookManager() {
        books = new ArrayList<>();
    }

    public static BookManager getInstance() {
        if (bookManager == null) {
            synchronized (BookManager.class) {
                if (bookManager == null) {
                    bookManager = new BookManager();
                }
            }
        }

        return bookManager;
    }

    public Book addBook() {

    }

    public List<Book> getBooks() {
        return books;
    }

    public List<Book> searchBookByTitle() {
        List<Book> bookSearchList =  books
                .stream()
                .allMatch(book -> book.)
    }

    public Book searchBookById() {

    }

    public Book updateBook() {

    }

    public void deleteBook() {

    }

    public void exit() {
        System.exit(1);
    }

}
