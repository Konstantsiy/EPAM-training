package com.epam.tasks.task4.main;

import com.epam.tasks.task4.entity.NumbersSet;
import com.epam.tasks.task4.report.Report;
import com.epam.tasks.task4.service.ComputingService;

public class Main {

    public static void main(String[] args) {
        NumbersSet inputSet = new NumbersSet(50); // random border
        ComputingService computingService = new ComputingService();
        inputSet.setFlag(computingService.checkSet(inputSet));
        Report report = new Report();
        report.getReport(inputSet);
    }
}
