package com.epam.tasks.library.reporter;

import com.epam.tasks.library.entity.Book;

import java.util.List;

public class LibraryReporter {

    public LibraryReporter(){}

    public void report(List<Book> books) {
        for(Book book : books) {
            System.out.println(book);
        }
    }
}
