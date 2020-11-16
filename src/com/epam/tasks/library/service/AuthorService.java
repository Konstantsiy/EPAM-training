package com.epam.tasks.library.service;

import com.epam.tasks.library.cache.AuthorCache;
import com.epam.tasks.library.entity.Author;
import com.epam.tasks.library.entity.Book;
import com.epam.tasks.library.exception.AuthorCacheException;

public class AuthorService {

    private final AuthorCache authorCache;

    public AuthorService() {
        authorCache = new AuthorCache();
    }

    public void addNewAuthor(Author author) throws AuthorCacheException {
        if(authorCache.contains(author)) {
            throw new AuthorCacheException("This author is already exist in cache.");
        } else {
            authorCache.add(author);
        }
    }

    public void addAuthorsFromBook(Book book) {
        for(Author author : book.getAuthors()) {
            if(!find(author)) {
                authorCache.add(author);
            }
        }
    }

    public boolean find(Author author) {
        return authorCache.contains(author);
    }
}
