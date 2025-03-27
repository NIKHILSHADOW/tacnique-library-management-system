package com.example.books;

import java.util.ArrayList;
import java.util.List;

public class BookManager {

    private BookManager bookManager;
    List<Book> books;

    private BookManager() {
        books = new ArrayList<>();
    }

    public BookManager getInstance() {
        if (bookManager == null) {
            synchronized (this) {
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

    }

    public List<Book> searchByTitle() {

    }

    public Book searchBookById() {

    }

    public Book updateBook() {

    }

    public void deleteBook() {

    }

    public void exit() {

    }

}
