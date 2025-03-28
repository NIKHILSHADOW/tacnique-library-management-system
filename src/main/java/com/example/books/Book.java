package com.example.books;

public class Book {

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

    public BookBuilder builder() {
        return new BookBuilder();
    }

    private class BookBuilder {
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
            if (title == null || title.length() == 0) {
                throw new RuntimeException("Title should not be null");
            }
            this.title = title;
            return this;
        }

        public BookBuilder author(String author) {
            if (author == null || author.length() == 0) {
                throw new RuntimeException("Author should not be null");
            }
            this.author = author;
            return this;
        }

        public BookBuilder genre(String genre) {
            this.genre = genre;
            return this;
        }

        public BookBuilder status(Status status) {
            this.status = status;
            return this;
        }

        public Book build() {
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
