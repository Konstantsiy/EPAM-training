package com.epam.tasks.library.exception;

public class BookCacheException extends Exception {

    public BookCacheException(String message) {
        super(message);
    }

    public String getErrorMessage() {
        return super.getMessage();
    }
}
