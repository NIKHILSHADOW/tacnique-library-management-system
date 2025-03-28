package com.example.books.services.impl;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.example.books.models.Book;
import com.example.books.models.Status;
import com.example.books.services.BookManager;

public class BookManagerImplTest {

    BookManager bookManager;

    @Before
    public void setup() {
        bookManager = BookManagerImpl.getInstance();
    }

    @After
    public void tearDown() {
        BookManagerImpl.resetInstance();
    }

    @Test
    public void testAddBook() {

        Assert.assertEquals(0, bookManager.getAllBooks().size());
        Book book = Book
                .builder()
                .author("samba")
                .id(1)
                .genre("horror")
                .title("cry")
                .status(Status.AVAILABLE)
                .build();
        bookManager.addBook(book);

        Assert.assertEquals(1, bookManager.getAllBooks().size());

    }

    @Test
    public void testGetAllBooks() {
        Assert.assertEquals(0, bookManager.getAllBooks().size());
        Book book = Book
                .builder()
                .author("samba")
                .id(1)
                .genre("horror")
                .title("cry")
                .status(Status.AVAILABLE)
                .build();
        bookManager.addBook(book);

        Book book1 = Book
                .builder()
                .author("samba")
                .id(2)
                .genre("horror")
                .title("cry")
                .status(Status.AVAILABLE)
                .build();
        bookManager.addBook(book1);

        Assert.assertEquals(2, bookManager.getAllBooks().size());
    }

    @Test
    public void testGetBookById() {
        Assert.assertEquals(0, bookManager.getAllBooks().size());
        Book book = Book
                .builder()
                .author("samba")
                .id(1)
                .genre("horror")
                .title("cry")
                .status(Status.AVAILABLE)
                .build();
        bookManager.addBook(book);

        Book book1 = Book
                .builder()
                .author("samba")
                .id(2)
                .genre("horror")
                .title("cry")
                .status(Status.AVAILABLE)
                .build();
        bookManager.addBook(book1);

        Assert.assertEquals(2, bookManager.getAllBooks().size());
        Assert.assertEquals("horror", bookManager.getBookById(2).getGenre());
    }

    @Test
    public void testGetBookBytitle() {
        Assert.assertEquals(0, bookManager.getAllBooks().size());
        Book book = Book
                .builder()
                .author("samba")
                .id(1)
                .genre("horror")
                .title("cry")
                .status(Status.AVAILABLE)
                .build();
        bookManager.addBook(book);

        Book book1 = Book
                .builder()
                .author("samba")
                .id(2)
                .genre("horror")
                .title("cry")
                .status(Status.AVAILABLE)
                .build();
        bookManager.addBook(book1);

        Assert.assertEquals(2, bookManager.getAllBooks().size());
        Assert.assertEquals(2, bookManager.getBooksByTitle("cry").size());
    }

    @Test
    public void testDeleteBook() {
        Assert.assertEquals(0, bookManager.getAllBooks().size());
        Book book = Book
                .builder()
                .author("samba")
                .id(1)
                .genre("horror")
                .title("cry")
                .status(Status.AVAILABLE)
                .build();
        bookManager.addBook(book);

        Book book1 = Book
                .builder()
                .author("samba")
                .id(2)
                .genre("horror")
                .title("cry")
                .status(Status.AVAILABLE)
                .build();
        bookManager.addBook(book1);
        bookManager.deleteBookById(2);

        Assert.assertEquals(1, bookManager.getAllBooks().size());
        Assert.assertEquals(1, bookManager.getBooksByTitle("cry").size());

    }

    @Test
    public void testUpdateBook() {
        Assert.assertEquals(0, bookManager.getAllBooks().size());
        Book book = Book
                .builder()
                .author("samba")
                .id(1)
                .genre("horror")
                .title("cry")
                .status(Status.AVAILABLE)
                .build();
        bookManager.addBook(book);

        Book book1 = Book
                .builder()
                .author("samba")
                .id(2)
                .genre("horror")
                .title("cry")
                .status(Status.AVAILABLE)
                .build();
        bookManager.addBook(book1);
        Book.BookBuilder bookBuilder = Book.builder().genre("comedy");

        Assert.assertEquals(2, bookManager.getAllBooks().size());
        Assert.assertEquals(2, bookManager.getBooksByTitle("cry").size());
        Assert.assertEquals("horror", bookManager.getBookById(2).getGenre());
        bookManager.update(2, bookBuilder);
        Assert.assertEquals("comedy", bookManager.getBookById(2).getGenre());

    }

}
