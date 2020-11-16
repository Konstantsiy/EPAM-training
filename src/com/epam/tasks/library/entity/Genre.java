package com.epam.tasks.library.entity;

import java.util.Objects;

public class Genre {
    private String genreTitle;

    public Genre(String genreTitle) {
        this.genreTitle = genreTitle;
    }

    public String getGenreTitle() {
        return genreTitle;
    }

    public void setGenreTitle(String genreTitle) {
        this.genreTitle = genreTitle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Genre genre = (Genre) o;
        return genreTitle.equals(genre.genreTitle);
    }

    @Override
    public String toString() {
        return "Genre{" +
                "genreTitle='" + genreTitle + '\'' +
                '}';
    }
}
