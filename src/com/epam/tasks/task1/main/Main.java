package com.epam.tasks.task1.main;

import com.epam.tasks.task1.report.Report;
import com.epam.tasks.task1.service.ComputingService;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Enter number: ");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        ComputingService computingService = new ComputingService();
        int lastDigit = computingService.determineLastSquareDigit(number);
        Report report = new Report();
        report.getReport(number, lastDigit);
    }
}
