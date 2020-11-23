package com.epam.tasks.array.reader;

import com.epam.tasks.array.entity.IntArray;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ArrayReader {

    public ArrayReader() {}

    public IntArray readFromConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter array size: ");
        int size;
        boolean flag;
        do {
            flag = true;
            size = scanner.nextInt();
            if(size < 0) {
                System.out.print("Array size can not be negative! try again: ");
                scanner.next();
                flag = false;
            }
        } while(!flag);
        int[] ms = new int[size];
        for(int i = 0; i < size; i++) {
            System.out.print("ms[" + i + "]: ");
            ms[i] = scanner.nextInt();
        }
        return new IntArray(ms);
    }

    public IntArray readFromFile(String filename) throws FileNotFoundException {
        File file = new File(filename);
        Scanner scanner = new Scanner(file);
        IntArray array = new IntArray();
        while (scanner.hasNextInt()) {
            array.add(scanner.nextInt());
        }
        scanner.close();
        return array;
    }

}
