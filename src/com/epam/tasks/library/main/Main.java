package com.epam.tasks.library.main;


import com.epam.tasks.library.entity.*;
import com.epam.tasks.library.exception.BookServiceException;
import com.epam.tasks.library.exception.IncorrectParameterException;
import com.epam.tasks.library.reporter.LibraryReporter;
import com.epam.tasks.library.service.BookService;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        try {
            Publisher p1 = new Publisher("Seeking House Peter");
            Publisher p2 = new Publisher("INSPIRIA");

            Author a2 = new Author("Ernest", "Hemingway");
            Author a1 = new Author("Stephen", "King");

            Book book1 = new Book("IT", 1987, 25.29, 230, Cover.HARD, p1, new Author[]{a1}, new Genre[]{Genre.FANTASY, Genre.HORROR, Genre.THRILLER});
            Book book2 = new Book("The old man and the sea", 1967, 30.29, 450, Cover.HARD, p2, new Author[]{a2}, new Genre[]{Genre.CLASSIC, Genre.THRILLER});

            Book[] books = {book1, book2};
            BookService bookService = new BookService();
            LibraryReporter libraryReporter = new LibraryReporter();

            List<Book> neededBook = bookService.getBookByGenre(books, Genre.THRILLER);
            libraryReporter.report(neededBook);
        } catch (BookServiceException | IncorrectParameterException e) {
            System.out.print(e.getMessage());
        }
    }
}
