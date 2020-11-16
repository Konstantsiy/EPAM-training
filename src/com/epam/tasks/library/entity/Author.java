package com.epam.tasks.library.entity;


import java.util.List;

public class Author {
    private String name;
    private String surname;
    private List<String> bookTitles;

    public Author(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public void addBookTitle(String title) {
        bookTitles.add(title);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<String> getBookTitles() {
        return bookTitles;
    }

    public void setBookTitles(List<String> bookTitles) {
        this.bookTitles = bookTitles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return name.equals(author.name) &&
                surname.equals(author.surname) &&
                bookTitles.equals(author.bookTitles);
    }
}
