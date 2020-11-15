package com.epam.tasks.task5.reader;

import java.util.Scanner;

public class CustomReader {

    private final Scanner scanner;

    public CustomReader() {
        scanner = new Scanner(System.in);
    }

    public int inputNaturalNumber() {
        boolean flag;
        int n;
        do{
            flag = true;
            n = scanner.nextInt();
            if(!scanner.hasNextInt() || n <= 0) {
                System.out.println("Positive integer number please!");
                flag = false;
            }
        } while (!flag);
        return n;
    }
}
