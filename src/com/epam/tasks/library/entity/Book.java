package com.epam.tasks.library.entity;

import com.epam.tasks.library.exception.IncorrectParameterException;
import com.epam.tasks.library.util.IdCounter;

import java.util.Arrays;
import java.util.Calendar;


public class Book {
    private final int id;
    private String title;
    private Publisher publisher;
    private int year;
    private double price;
    private int pagesNumber;
    private Cover cover;
    private Author[] authors;
    private Genre[] genres;

    public Book(String title, int year, double price,
                int pagesNumber, Cover cover, Publisher publisher,  Author[] authors, Genre[] genres) throws IncorrectParameterException {
        if(!title.isBlank() &&
                year > 0 && year <= Calendar.getInstance().getWeekYear() &&
                price >= 0 &&
                pagesNumber > 0 &&
                authors.length > 0 &&
                genres.length > 0) {
            this.id = IdCounter.getInstance().getNext();
            this.title = title;
            this.publisher = publisher;
            this.year = year;
            this.price = price;
            this.pagesNumber = pagesNumber;
            this.cover = cover;
            this.authors = authors;
            this.genres = genres;
        } else {
            throw new IncorrectParameterException("Incorrect initialization parameters");
        }
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) throws IncorrectParameterException {
        if(!title.isBlank()) {
            this.title = title;
        } else {
            throw new IncorrectParameterException("Book title cannot be empty");
        }
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) throws IncorrectParameterException {
        if(year > 0 && year <= Calendar.getInstance().getWeekYear()) {
            this.year = year;
        } else {
            throw new IncorrectParameterException("The year must be no more than the current year and no less than zero");
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) throws IncorrectParameterException {
        if(price >= 0) {
            this.price = price;
        } else {
            throw new IncorrectParameterException("Book price should not be negative");
        }
    }

    public int getPagesNumber() {
        return pagesNumber;
    }

    public void setPagesNumber(int pagesNumber) throws IncorrectParameterException {
        if(pagesNumber > 0) {
            this.pagesNumber = pagesNumber;
        } else {
            throw new IncorrectParameterException("The number of pages must be greater than zero");
        }
    }

    public Cover getCover() {
        return cover;
    }

    public void setCover(Cover cover) {
        this.cover = cover;
    }

    public Author[] getAuthors() {
        return authors;
    }

    public void setAuthors(Author[] authors) throws IncorrectParameterException {
        if(authors.length > 0) {
            this.authors = authors;
        } else {
            throw new IncorrectParameterException("The book must have at least one author");
        }

    }

    public Genre[] getGenres() {
        return genres;
    }

    public void setGenres(Genre[] genres) throws IncorrectParameterException {
        if(genres.length > 0) {
            this.genres = genres;
        } else {
            throw new IncorrectParameterException("The book must have at least one genre");
        }
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
                Arrays.equals(authors, book.authors) &&
                Arrays.equals(genres, book.genres);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Book:\n");
        stringBuilder
                .append("\t\tid: ").append(id).append("\n")
                .append("\t\ttitle: ").append(title).append("\n")
                .append("\t\tyear: ").append(year).append("\n")
                .append("\t\tprice: ").append(price).append("\n")
                .append("\t\tpages: ").append(pagesNumber).append("\n")
                .append("\t\tcover: ").append(cover).append("\n")
                .append("\t\tauthors: ").append(Arrays.toString(authors)).append("\n")
                .append("\t\tgenres: ").append(Arrays.toString(genres)).append("\n");
        return stringBuilder.toString();
    }
}
