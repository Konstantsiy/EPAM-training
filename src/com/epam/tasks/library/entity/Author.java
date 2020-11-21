package com.epam.tasks.library.entity;


import com.epam.tasks.library.exception.IncorrectParameterException;

public class Author {
    private String name;
    private String surname;

    public Author(String name, String surname) throws IncorrectParameterException {
        if(!name.isBlank() && name.matches("[a-zA-Z-]+") && !surname.isBlank() && surname.matches("[a-zA-Z-]+")) {
            this.name = name;
            this.surname = surname;
        } else {
            throw new IncorrectParameterException("Incorrect name or surname");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws IncorrectParameterException {
        if(!name.isBlank() && name.matches("[a-zA-Z-]+")) {
            this.name = name;
        } else {
            throw new IncorrectParameterException("The authors name can contain only Latin characters and a hyphen");
        }
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) throws IncorrectParameterException {
        if(!surname.isBlank() && surname.matches("[a-zA-Z-]+")) {
            this.surname = surname;
        } else {
            throw new IncorrectParameterException("The authors surname can contain only Latin characters and a hyphen");
        }

    }

    @Override
    public String toString() {
        return name + " " + surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return name.equals(author.name) &&
                surname.equals(author.surname);
    }
}
