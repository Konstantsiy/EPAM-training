package com.epam.tasks.task6.main;

import com.epam.tasks.task5.reader.CustomReader;
import com.epam.tasks.task6.entity.Time;
import com.epam.tasks.task6.report.Report;
import com.epam.tasks.task6.service.TimeService;

public class Main{

    public static void main(String[] args) {
        CustomReader reader = new CustomReader();
        TimeService dateTimeService = new TimeService();
        int number = reader.inputNaturalNumber();
        Time time = dateTimeService.convertSeconds(number);
        Report report = new Report();
        report.getReport(time);
    }
}
