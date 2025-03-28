package com.example.books.services;

import java.util.List;

import com.example.books.models.Book;

public interface BookManager {

    public Book addBook(Book book);

    public List<Book> getAllBooks();

    public Book getBookById(Integer id);

    public List<Book> getBooksByTitle(String title);

    public Book update(Integer id, Book.BookBuilder bookBuilder);

    public void deleteBookById(Integer id);

}
