package com.epam.tasks.library.entity;

import java.util.ArrayList;
import java.util.Objects;


public class Book {
    private static int counter = 1;
    private int id;
    private String title;
    private Publisher publisher;
    private int year;
    private int price;
    private int pagesNumber;
    private Cover cover;
    private ArrayList<Author> authors;
    private ArrayList<Genre> genres;

    private Book(){}

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public int getYear() {
        return year;
    }

    public int getPrice() {
        return price;
    }

    public int getPagesNumber() {
        return pagesNumber;
    }

    public Cover getCover() {
        return cover;
    }

    public ArrayList<Author> getAuthors() {
        return authors;
    }

    public ArrayList<Genre> getGenres() {
        return genres;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id &&
                year == book.year &&
                price == book.price &&
                pagesNumber == book.pagesNumber &&
                title.equals(book.title) &&
                publisher.equals(book.publisher) &&
                cover.getTitle().equals(book.cover.getTitle()) &&
                authors.equals(book.authors) &&
                genres.equals(book.genres);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", publisher=" + publisher +
                ", year=" + year +
                ", price=" + price +
                ", pagesNumber=" + pagesNumber +
                ", cover=" + cover +
                ", authors=" + authors +
                ", genres=" + genres +
                '}';
    }

    public static class Builder {
        private Book newBook;

        public Builder() {
            newBook = new Book();
        }

        public Builder withTitle(String title) {
            newBook.title = title;
            return this;
        }

        public Builder withYear(int year) {
            newBook.year = year;
            return this;
        }

        public Builder withPrice(int price) {
            newBook.price = price;
            return this;
        }

        public Builder withPagesNumber(int n) {
            newBook.pagesNumber = n;
            return this;
        }

        public Builder withPublisher(Publisher publisher) {
            newBook.publisher = publisher;
            return this;
        }

        public Builder withCover(Cover cover) {
            newBook.cover = cover;
            return this;
        }

        public Builder withAuthors(ArrayList<Author> authors) {
            newBook.authors = authors;
            return this;
        }

        public Builder withGenres(ArrayList<Genre> genres) {
            newBook.genres = genres;
            return this;
        }

        public Book build() {
            newBook.id = counter;
            counter++;
            return newBook;
        }

    }
}
