package com.epam.tasks.library.cache;

import com.epam.tasks.library.entity.Author;


import java.util.ArrayList;

public class AuthorCache {

    private ArrayList<Author> existingAuthors;

    public AuthorCache() {
        this.existingAuthors = new ArrayList<>();
    }

    public void add(Author author) {
        existingAuthors.add(author);
    }

    public boolean contains(Author author) {
        return existingAuthors.contains(author);
    }
}
