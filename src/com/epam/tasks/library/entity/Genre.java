package com.epam.tasks.library.entity;

public enum Genre {
    DETECTIVE ("Detective"),
    FICTION ("Fiction"),
    FANTASY ("Fantasy"),
    THRILLER ("Thriller"),
    HORROR ("Horror"),
    ADVENTURE ("Adventure"),
    EROTIC ("Erotic"),
    CLASSIC ("Classic");

    private final String title;

    Genre(String s) {
        this.title = s;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return title;
    }
}
