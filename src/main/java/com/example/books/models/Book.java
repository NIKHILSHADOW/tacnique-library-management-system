package com.example.books.models;

import java.util.HashSet;
import java.util.Set;

public class Book {

    private static Set<Integer> bookIds = new HashSet<>();
    private Integer id;
    private String title;
    private String author;
    private String genre;
    private Status status;

    private Book() {

    }

    public Integer getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getGenre() {
        return this.genre;
    }

    public Status getStatus() {
        return this.status;
    }

    public void status(Status status) {
        this.status = status;
    }

    public void author(String author) {
        if (author == null || author.isEmpty()) {
            throw new RuntimeException("author cannot be empty");
        }
        this.author = author;
    }

    public void title(String title) {
        if (title == null || title.isEmpty()) {
            throw new RuntimeException("title cannot be empty");
        }
        this.title = title;
    }

    public void genre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Book Info \nid = " + this.id + "\ntitle = " + this.title + "\nauthor = " + this.author + "\ngenre = "
                + this.genre + "\nstatus = " + this.status;
    }

    public static BookBuilder builder() {
        return new BookBuilder();
    }

    public static class BookBuilder {
        private Integer id;
        private String title;
        private String author;
        private String genre;
        private Status status;

        public BookBuilder id(Integer id) {
            this.id = id;
            return this;
        }

        public BookBuilder title(String title) {
            this.title = title;
            return this;
        }

        public String getTitle() {
            return this.title;
        }

        public BookBuilder author(String author) {
            this.author = author;
            return this;
        }

        public String getAuthor() {
            return this.author;
        }

        public BookBuilder genre(String genre) {
            this.genre = genre;
            return this;
        }

        public String getGenre() {
            return this.genre;
        }

        public BookBuilder status(Status status) {
            this.status = status;
            return this;
        }

        public Status getStatus() {
            return this.status;
        }

        private Boolean checkValid() {
            if (id == null) {
                throw new RuntimeException("Id should not be null");
            }
            if (bookIds.contains(id)) {
                throw new RuntimeException("Book with given Id already exist, Id should be unique");
            }
            if (author == null || author.length() == 0) {
                throw new RuntimeException("Author should not be null");
            }

            if (title == null || title.length() == 0) {
                throw new RuntimeException("Title should not be null");
            }

            return true;
        }

        public Book build() {

            if (!checkValid())
                return null;

            Book book = new Book();
            book.id = this.id;
            book.title = this.title;
            book.author = this.author;
            book.genre = this.genre;
            book.status = this.status;

            return book;
        }

    }

}
