package com.example;

import java.util.List;
import java.util.Scanner;

import com.example.books.models.Book;
import com.example.books.models.Status;
import com.example.books.services.BookManager;
import com.example.books.services.impl.BookManagerImpl;

/**
 * Hello world!
 *
 */
public class App {
    private static Scanner sc;

    public App() {
        sc = new Scanner(System.in);
    }

    public static void main(String[] args) {
        BookManager bookManager = BookManagerImpl.getInstance();
        Book book;
        List<Book> books;

        while (true) {
            System.out.println(
                    "Choose the below option /n1. addBook /n2. showBooks /n3. search Book By Id /n4. search Book by title /n5. update Book by Id /n6. delete Book /n7. Exit /n");

            Integer x = sc.nextInt();
            Integer id;
            Status status;
            String title, author, genre;

            switch (x) {
                case 1:
                    System.out.println("Enter book id, title, author, genre, status");
                    System.out.println("Enter Book id");
                    id = sc.nextInt();
                    System.out.println("Enter Book title");
                    title = sc.nextLine();
                    System.out.println("Enter Book author");
                    author = sc.nextLine();
                    System.out.println("Enter Book genre");
                    genre = sc.nextLine();
                    System.out.println("Enter Book status if Available 1 else 0");
                    Integer d = sc.nextInt();
                    status = (d == 1) ? Status.AVAILABLE : Status.CHECKEDOUT;
                    book = Book.builder()
                            .id(id)
                            .author(author)
                            .title(title)
                            .genre(genre)
                            .status(status)
                            .build();

                    break;
                case 2:
                    books = bookManager.getAllBooks();
                    books.stream().forEach(book1 -> System.out.println(book1.toString()));
                    break;
                case 3:
                    System.out.println("Enter Book Id");
                    id = sc.nextInt();
                    book = bookManager.getBookById(id);
                    System.out.println(book.toString());
                    break;
                case 4:
                    System.out.println("Enter Book title");
                    title = sc.nextLine();
                    books = bookManager.getBooksByTitle(title);
                    books.stream().forEach(book1 -> System.out.println(book1.toString()));
                    break;
                case 5:
                    System.out.println("Enter Book Id which you want to update");
                    id = sc.nextInt();
                    System.out.println("Enter Book title");
                    title = sc.nextLine();
                    System.out.println("Enter Book author");
                    author = sc.nextLine();
                    System.out.println("Enter Book genre");
                    genre = sc.nextLine();
                    System.out.println("Enter Book status if Available 1 else 0");
                    d = sc.nextInt();
                    status = (d == null) ? null : ((d == 1) ? Status.AVAILABLE : Status.CHECKEDOUT);
                    Book.BookBuilder bookBuilder = Book.builder()
                            .author(author)
                            .genre(genre)
                            .title(title)
                            .status(status);
                    book = bookManager.update(id, bookBuilder);
                    System.out.println(book.toString());
                    break;
                case 6:
                    bookManager.deleteBookById(1);
                    break;
                // case 7 :
                // break;
                default:
                    // throw new RuntimeException("Choose Option from the given list");
            }

            if (x == 7) {
                System.exit(0);
            }
        }
    }
}
