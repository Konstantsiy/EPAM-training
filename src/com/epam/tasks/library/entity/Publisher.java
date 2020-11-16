package com.epam.tasks.library.entity;

import java.util.ArrayList;
import java.util.Objects;

public class Publisher {
    private String title;
    ArrayList<Book> releasedBooks;

    public Publisher(String title, ArrayList<Book> releasedBooks) {
        this.title = title;
        this.releasedBooks = releasedBooks;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<Book> getReleasedBooks() {
        return releasedBooks;
    }

    public void setReleasedBooks(ArrayList<Book> releasedBooks) {
        this.releasedBooks = releasedBooks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publisher publisher = (Publisher) o;
        return title.equals(title) &&
                releasedBooks.equals(publisher.getReleasedBooks());
    }
}
