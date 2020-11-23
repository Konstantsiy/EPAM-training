package com.epam.tasks.library.service;

import com.epam.tasks.library.entity.*;

import com.epam.tasks.library.exception.BookServiceException;
import com.epam.tasks.library.exception.IncorrectParameterException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class LibraryServiceTest {

    private final BookService bookService = new BookService();
    private Book[] books;
    private Author[] authors;
    private Publisher[] publishers;

    @BeforeClass
    public void initBookSet(){
        try{
            Author a1 = new Author("Ernest", "Hemingway");
            Author a2 = new Author("Stephen", "King");
            Author a3 = new Author("Franklin", "Herbert");
            authors = new Author[]{a1, a2, a3};

            Publisher p1 = new Publisher("Berlitz");
            Publisher p2 = new Publisher("Nielsen");
            Publisher p3 = new Publisher("Feral House");
            publishers = new Publisher[]{p1, p2, p3};

            Book b1 = new Book("IT", 1986, 29.99, 1138, Cover.HARD, p1,
                    new Author[]{a2}, new Genre[]{Genre.THRILLER, Genre.HORROR, Genre.FANTASY});
            Book b2 = new Book("The old man and the sea", 1952, 19.99, 127, Cover.HARD, p2,
                    new Author[]{a1}, new Genre[]{Genre.CLASSIC});
            Book b3 = new Book("Pet Sematary", 1983, 23.36, 373, Cover.HARD, p3,
                    new Author[]{a2}, new Genre[]{Genre.THRILLER, Genre.HORROR});
            Book b4 = new Book("Dune", 1965, 39.59, 412, Cover.HARD, p2,
                    new Author[]{a3}, new Genre[]{Genre.FICTION, Genre.ADVENTURE});
            books = new Book[]{b1, b2, b3, b4};

        } catch (IncorrectParameterException e) {
            System.out.print(e.getMessage());
        }

    }

    @Test
    public void testGetMostCheapestBook() {
        try {
            Assert.assertEquals(bookService.getCheapestBook(books), books[1]);
        } catch (BookServiceException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetMostExpensiveBook() {
        try {
            Assert.assertEquals(bookService.getMostExpensiveBook(books), books[3]);
        } catch (BookServiceException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetBookByAuthor() {
        try {
            Assert.assertEquals(bookService.getBookByAuthor(books, authors[1]).length, 2);
            Assert.assertEquals(bookService.getBookByAuthor(books, authors[0]).length, 1);
        } catch (BookServiceException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetBookByGenre() {
        try {
            Assert.assertEquals(bookService.getBookByGenre(books, Genre.HORROR).length, 2);
            Assert.assertEquals(bookService.getBookByGenre(books, Genre.ADVENTURE).length, 1);
        } catch (BookServiceException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetBooksAfterYear() {
        try {
            Assert.assertEquals(bookService.getBooksAfterYear(books, 1900).length, 4);
            Assert.assertEquals(bookService.getBooksAfterYear(books, 1960).length, 3);
        } catch (BookServiceException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetBooksByPublisher() {
        try {
            Assert.assertEquals(bookService.getBooksByPublisher(books, publishers[0]).length, 1);
        } catch (BookServiceException e) {
            e.printStackTrace();
        }
    }
}