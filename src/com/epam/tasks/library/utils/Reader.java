package com.epam.tasks.library.utils;

import com.epam.tasks.library.entity.Author;
import com.epam.tasks.library.entity.Book;
import com.epam.tasks.library.entity.Cover;
import com.epam.tasks.library.entity.Genre;


import java.util.ArrayList;
import java.util.Scanner;


public class Reader {

    private final String ERROR_MESSAGE_1 = "ERROR: you need enter a positive number!";
    private final String ERROR_MESSAGE_2 = "ERROR: The entered type must match the existing ones!";


    private final Scanner scanner;

    public Reader() {
        this.scanner = new Scanner(System.in);
    }

    public int readPositiveNumber() {
        int number;
        do{
            while(!scanner.hasNextInt()) {
                System.out.println(ERROR_MESSAGE_1);
                scanner.next();
            }
            number = scanner.nextInt();
        } while (number <= 0);
        return number;
    }

    public int readOption(int min, int max) {
        int op;
        boolean flag;
        do {
            flag = true;
            op = scanner.nextInt();
            if(op < min || op > max) {
                System.out.print("Try again.\n");
                scanner.next();
                flag = false;
            }
        } while (!flag);
        return op;
    }

    public Cover readCover() {
        for(Cover cover : Cover.values()) {
            System.out.print(cover.getTitle() + " / ");
        }
        String coverType;
        boolean flag;
        do {
            flag = true;
            coverType = scanner.nextLine();
            if(!Cover.check(coverType)) {
                System.out.println(ERROR_MESSAGE_2);
                scanner.next();
                flag = false;
            }
        } while (!flag);
        return Cover.valueOf(coverType);
    }

    public Author readAuthor() {
        System.out.print("\t\tname: ");
        String name = scanner.nextLine();
        System.out.print("\t\tsurname: ");
        String surname = scanner.nextLine();
        return new Author(name, surname);
    }



    public ArrayList<Author> readAuthors() {
        ArrayList<Author> authors = new ArrayList<>();
        boolean flag;
        do {
            flag = true;
            Author author = readAuthor();
            authors.add(author);
            System.out.print("Add another author? [y/n] ");
            if(scanner.nextLine().equals("y")) {
                flag = false;
            }
        } while (!flag);
        return authors;
    }

    public Genre readGenre() {
        String title = scanner.nextLine();
        return new Genre(title);
    }

    public ArrayList<Genre> readGenres() {
        ArrayList<Genre> genres = new ArrayList<>();
        boolean flag;
        do {
            flag = true;
            System.out.print("Enter genre title: ");
            Genre genre = readGenre();
            genres.add(genre);
            System.out.print("add another genre? [y/n] ");
            if(scanner.nextLine().equals("y")) {
                flag = false;
            }
        } while (!flag);
        return genres;
    }

    public Book readBook() {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter book published year: ");
        int year = readPositiveNumber();
        System.out.print("Enter book price: ");
        int price = readPositiveNumber();
        System.out.println("Enter book pages number: ");
        int pagesNumber = readPositiveNumber();
        System.out.print("Choose a cover: ");
        Cover cover = readCover();
        System.out.print("Enter publisher title: ");
        String publisher = scanner.nextLine();
        System.out.println("Enter book author: ");
        ArrayList<Author> authors = readAuthors();
        System.out.print("Enter book genres: ");
        ArrayList<Genre> genres = readGenres();
        Book newBook = new Book.Builder()
                .withTitle(title)
                .withYear(year)
                .withPrice(price)
                .withCover(cover)
                .withPagesNumber(pagesNumber)
                .withAuthors(authors)
                .withGenres(genres)
                .build();

        return newBook;
    }



}
