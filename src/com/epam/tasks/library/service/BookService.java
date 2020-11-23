package com.epam.tasks.library.service;


import com.epam.tasks.library.entity.Author;
import com.epam.tasks.library.entity.Book;
import com.epam.tasks.library.entity.Genre;
import com.epam.tasks.library.entity.Publisher;
import com.epam.tasks.library.exception.BookServiceException;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BookService {

   public BookService(){}

    public Book[] getBookByAuthor(Book[] books, Author author) throws BookServiceException {
        Book[] neededBooks = (Book[]) Arrays.stream(books)
                .filter(book -> Arrays.asList(book.getAuthors())
                .contains(author))
                .toArray();

        if(neededBooks.length == 0) {
            throw new BookServiceException("There are no books with author " + author);
        }
        return neededBooks;
    }

    public Book[] getBookByGenre(Book[] books, Genre genre) throws BookServiceException {
       Book[] neededBooks = (Book[]) Arrays.stream(books)
               .filter(book -> Arrays.asList(book.getGenres())
               .contains(genre))
               .toArray();

       if(neededBooks.length == 0) {
           throw new BookServiceException("There are no books with genre " + genre);
       }
       return neededBooks;
    }

    public Book[] getBooksAfterYear(Book[] books, int year) throws BookServiceException {
       Book[] neededBooks = (Book[]) Arrays.stream(books)
               .filter(book -> book.getYear() > year).toArray();

       if(neededBooks.length == 0) {
           throw new BookServiceException("There are no books after " + year);
       }
       return neededBooks;
    }

    public Book[] getBooksByPublisher(Book[] books, Publisher publisher) throws BookServiceException {
       Book[] neededBooks = (Book[]) Arrays.stream(books)
               .filter(book -> book.getPublisher()
               .equals(publisher))
               .toArray();

       if(neededBooks.length == 0) {
           throw new BookServiceException("There are no books with publisher " + publisher);
       }
       return neededBooks;
    }

    public Book getCheapestBook(Book[] books) throws BookServiceException {
        return Arrays.stream(books)
                .min(Comparator.comparing(Book::getPrice))
                .orElseThrow(() -> new BookServiceException("The most cheapest book not found"));
    }

    public Book getMostExpensiveBook(Book[] books) throws BookServiceException {
       return Arrays.stream(books)
               .max(Comparator.comparing(Book::getPrice))
               .orElseThrow(() -> new BookServiceException("The most expensive book not found"));
    }

}
