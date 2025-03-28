package com.example;

import org.junit.Assert;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import com.example.books.models.Book;
import com.example.books.models.Status;
import com.example.books.services.BookManager;
import com.example.books.services.impl.BookManagerImpl;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void testBookManagerImplInstance() {
        BookManager bookManagerImpl = BookManagerImpl.getInstance();
        BookManager bookManagerImpl2 = BookManagerImpl.getInstance();

        Assert.assertNotNull("BookManger instance should not be null", bookManagerImpl);
        Assert.assertNotNull("BookManger instance should not be null", bookManagerImpl2);

        Assert.assertEquals(bookManagerImpl, bookManagerImpl2);
    }

    @Test
    public void testBookInstance() {
        Book book = Book
                .builder()
                .author("ramesh")
                .genre("fiction")
                .title("kingdom")
                .id(1)
                .status(Status.AVAILABLE)
                .build();

        Assert.assertNotNull("Instance creation failed", book);
        Assert.assertEquals("ramesh", book.getAuthor());
        Assert.assertTrue(book.getGenre().equals("fiction"));
        Assert.assertTrue(book.getTitle().equals("kingdom"));
        Assert.assertTrue(book.getStatus() == Status.AVAILABLE);
    }

    @Test(expected = RuntimeException.class)
    public void testBookTitle() {
        Book book = Book.builder()
                .genre("action")
                .author("james")
                .id(2)
                .status(Status.AVAILABLE)
                .build();
        Assert.assertNotNull(book);

    }

    @Test(expected = RuntimeException.class)
    public void testBookId() {
        Book book = Book.builder()
                .genre("action")
                .author("james")
                .title("forest")
                .status(Status.AVAILABLE)
                .build();
        Assert.assertNotNull(book);

    }

    @Test(expected = RuntimeException.class)
    public void testBookAuthor() {
        Book book = Book.builder()
                .genre("action")
                .title("forest")
                .author("")
                .id(2)
                .status(Status.AVAILABLE)
                .build();
        Assert.assertNotNull(book);
    }
}
