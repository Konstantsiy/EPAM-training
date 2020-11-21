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

    public List<Book> getBookByAuthor(Book[] books, Author author) throws BookServiceException {
        List<Book> neededBooks = Arrays.stream(books)
                .filter(book -> Arrays.asList(book.getAuthors()).contains(author))
                .collect(Collectors.toList());

        if(neededBooks.isEmpty()) {
            throw new BookServiceException("There are no books with author " + author);
        }
        return neededBooks;
    }

    public List<Book> getBookByGenre(Book[] books, Genre genre) throws BookServiceException {
       List<Book> neededBooks = Arrays.stream(books)
               .filter(book -> Arrays.asList(book.getGenres()).contains(genre))
               .collect(Collectors.toList());

       if(neededBooks.isEmpty()) {
           throw new BookServiceException("There are no books with genre " + genre);
       }
       return neededBooks;
    }

    public List<Book> getBooksAfterYear(Book[] books, int year) throws BookServiceException {
       List<Book> neededBooks = Arrays.stream(books)
               .filter(book -> book.getYear() > year)
               .collect(Collectors.toList());

       if(neededBooks.isEmpty()) {
           throw new BookServiceException("There are no books after " + year);
       }
       return neededBooks;
    }

    public List<Book> getBooksByPublisher(Book[] books, Publisher publisher) throws BookServiceException {
       List<Book> neededBooks =  Arrays.stream(books)
               .filter(book -> book.getPublisher().equals(publisher))
               .collect(Collectors.toList());

       if(neededBooks.isEmpty()) {
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
