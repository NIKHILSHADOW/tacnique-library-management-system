package com.example.books.services.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.example.books.models.Book;
import com.example.books.services.BookManager;

public class BookManagerImpl implements BookManager {

    private static Map<Integer, Book> books;
    private static volatile BookManagerImpl bookManagerImpl;

    private BookManagerImpl() {
        books = new HashMap<>();
    }

    @SuppressWarnings("DoubleCheckedLocking")
    public static BookManagerImpl getInstance() {
        if (bookManagerImpl == null) {
            synchronized (BookManagerImpl.class) {
                if (bookManagerImpl == null) {
                    bookManagerImpl = new BookManagerImpl();
                }
            }
        }
        return bookManagerImpl;
    }

    protected static void resetInstance() {
        bookManagerImpl = null;
    }

    @Override
    public Book addBook(Book book) {
        books.put(book.getId(), book);
        return book;
    }

    @Override
    public List<Book> getAllBooks() {
        return books.values().stream().collect(Collectors.toList());
    }

    @Override
    public Book getBookById(Integer id) {
        return books.get(id);
    }

    @Override
    public List<Book> getBooksByTitle(String title) {
        return books.values().stream()
                .filter(book -> book.getTitle().equals(title))
                .collect(Collectors.toList());
    }

    @Override
    public Book update(Integer id, Book.BookBuilder bookBuilder) {
        Book book = books.get(id);
        if (bookBuilder.getAuthor() != null && !bookBuilder.getAuthor().isEmpty()) {
            book.author(bookBuilder.getAuthor());
        }

        if (bookBuilder.getTitle() != null && !bookBuilder.getTitle().isEmpty()) {
            book.title(bookBuilder.getTitle());
        }

        if (bookBuilder.getStatus() != null) {
            book.status(bookBuilder.getStatus());
        }

        if (bookBuilder.getGenre() != null) {
            book.genre(bookBuilder.getGenre());
        }

        return book;
    }

    @Override
    public void deleteBookById(Integer id) {
        books.remove(id);
    }

}
