package com.epam.tasks.library.exception;

public class AuthorCacheException extends Exception {

    public AuthorCacheException(String message) {
        super(message);
    }

    public String getErrorMessage() {
        return super.getMessage();
    }
}
