package com.epam.tasks.library.entity;


import com.epam.tasks.library.exception.IncorrectParameterException;

public class Publisher {
    private String title;

    public Publisher(String title) throws IncorrectParameterException {
        if(!title.isBlank()) {
            this.title = title;
        } else {
            throw new IncorrectParameterException("Publisher title cannot be empty");
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) throws IncorrectParameterException {
        if(!title.isBlank()) {
            this.title = title;
        } else {
            throw new IncorrectParameterException("Publisher title cannot be empty");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publisher publisher = (Publisher) o;
        return title.equals(publisher.title);
    }

    @Override
    public String toString() {
        return title;
    }
}
