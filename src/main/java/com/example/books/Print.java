package com.example.books;

import java.util.List;

import com.example.books.models.Book;

public class Print {

    public void print(Book book) {
        System.out.println("Book : /nId : " + book.getId() + "/n title : " + book.getTitle() + "/n author : "
                + book.getAuthor() + "/n genre : " + book.getGenre() + "/n status : " + book.getStatus());
    }

    public void print(List<Book> books) {
        books.stream()
                .forEach(book -> print(book));
    }
}
