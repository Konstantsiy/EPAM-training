package com.epam.tasks.library.cache;

import com.epam.tasks.library.entity.Book;


import java.util.ArrayList;

public class BookCache {

    private ArrayList<Book> existingBooks;

    public BookCache() {
        this.existingBooks = new ArrayList<>();
    }

    public ArrayList<Book> getExistingBooks() {
        return existingBooks;
    }

    public void add(Book book) {
        existingBooks.add(book);
    }

    public boolean contains(Book book) {
        return existingBooks.contains(book);
    }
}
