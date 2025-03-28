package com.example;

import java.util.Scanner;

import com.example.books.BookManager;

/**
 * Hello world!
 *
 */
public class App {
    private static Scanner sc;

    public static void main(String[] args) {
        BookManager bookManager = BookManager.getInstance();

        while (true) {
            System.out.println(
                    "Choose the below option /n1. addBook /n2. showBooks /n3. search Book By Id /n4. search Book by title /n5. update Book by Id /n6. delete Book /n7. Exit /n");

            Integer x = sc.nextInt();

            switch (x) {
                case 1:
                    bookManager.addBook();
                    break;
                case 2:
                    bookManager.getBooks();
                    break;
                case 3:
                    bookManager.searchBookById();
                    break;
                case 4:
                    bookManager.searchBookByTitle();
                    break;
                case 5:
                    bookManager.updateBook();
                    break;
                case 6:
                    bookManager.deleteBook();
                    break;
                case 7:
                    bookManager.exit();
                    break;
                default:
                    throw new RuntimeException("Choose Option from the given list");
            }

        }
    }
}
