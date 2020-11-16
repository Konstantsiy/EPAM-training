package com.epam.tasks.library.service;

import com.epam.tasks.library.cache.BookCache;
import com.epam.tasks.library.entity.Author;
import com.epam.tasks.library.entity.Book;
import com.epam.tasks.library.entity.Genre;
import com.epam.tasks.library.exception.BookCacheException;

import java.util.ArrayList;

public class BookService {

    private final BookCache bookCache;

    public BookService(){
        bookCache = new BookCache();
    }

    public void addNewBook(Book book) throws BookCacheException {
        if(bookCache.contains(book)) {
            throw new BookCacheException("This book is already exist in cache.");
        } else {
            bookCache.add(book);

        }
    }

    public ArrayList<Book> findByAuthor(Author author) {
        ArrayList<Book> neededBooks = new ArrayList<>();
        for(Book book : bookCache.getExistingBooks()) {
            if(book.getAuthors().contains(author)) {
                neededBooks.add(book);
            }
        }
        return neededBooks;
    }

    public ArrayList<Book> findByPublishingYear(int year) {
        ArrayList<Book> neededBooks = new ArrayList<>();
        for(Book book : bookCache.getExistingBooks()) {
            if(year == book.getYear()) {
                neededBooks.add(book);
            }
        }
        return neededBooks;
    }

    public ArrayList<Book> findByGenre(Genre genre) {
        ArrayList<Book> neededBooks = new ArrayList<>();
        for(Book book : bookCache.getExistingBooks()) {
            if(book.getGenres().contains(genre)) {
                neededBooks.add(book);
            }
        }
        return neededBooks;
    }

}
