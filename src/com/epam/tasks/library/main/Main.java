package com.epam.tasks.library.main;

import com.epam.tasks.library.entity.Author;
import com.epam.tasks.library.entity.Book;
import com.epam.tasks.library.entity.Genre;
import com.epam.tasks.library.exception.BookCacheException;
import com.epam.tasks.library.service.AuthorService;
import com.epam.tasks.library.service.BookService;
import com.epam.tasks.library.utils.Reader;

import java.util.ArrayList;

public class Main {

    public static Reader reader = new Reader();
    public static BookService bookService = new BookService();
    public static AuthorService authorService = new AuthorService();

    public static void main(String[] args) {
        Reader reader = new Reader();
        boolean flag = true;
        while(flag) {
            menu();
            int op = reader.readOption(0, 4);
            switch (op) {
                case 1 -> addNewBook();
                case 2 -> viewBooksBuAuthor();
                case 3 -> viewBooksByPublishingYear();
                case 4 -> viewBooksByGenre();
                case 0 -> flag = false;
            }
        }

    }

    public static void menu() {
        System.out.println("1. Add book.\n");
        System.out.println("2. View books by author.\n");
        System.out.println("3. View books by publishing year.\n");
        System.out.println("4. View books by genre.\n");
        System.out.println("0. Out.");
        System.out.print("> ");
    }


    public static void addNewBook() {
        Book newBook = reader.readBook();
        try {
            bookService.addNewBook(newBook);
            authorService.addAuthorsFromBook(newBook);
        } catch (BookCacheException e) {
            System.out.print(e.getErrorMessage());
        }
    }

    public static void viewBooksBuAuthor() {
        System.out.println("Enter info about author: ");
        Author author = reader.readAuthor();
        ArrayList<Book> neededBooks = bookService.findByAuthor(author);
        System.out.println(neededBooks.toString());
    }

    public static void viewBooksByPublishingYear() {
        System.out.println("Enter year: ");
        int year = reader.readPositiveNumber();
        ArrayList<Book> neededBooks = bookService.findByPublishingYear(year);
        System.out.println(neededBooks.toString());
    }

    public static void viewBooksByGenre() {
        System.out.print("Enter genre title: ");
        Genre genre = reader.readGenre();
        ArrayList<Book> neededBooks = bookService.findByGenre(genre);
        System.out.println(neededBooks.toString());
    }


}
