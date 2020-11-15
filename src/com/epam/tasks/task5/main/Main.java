package com.epam.tasks.task5.main;

import com.epam.tasks.task5.reader.CustomReader;
import com.epam.tasks.task5.service.ComputingService;

public class Main {

    public static void main(String[] args) {
        CustomReader reader = new CustomReader();
        ComputingService computingService = new ComputingService();
        System.out.print("Enter number: ");
        int n = reader.inputNaturalNumber();
        System.out.println(computingService.isPerfect(n));
    }
}
