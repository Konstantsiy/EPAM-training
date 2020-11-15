package com.epam.tasks.task2.main;

import com.epam.tasks.task2.entity.CustomDate;
import com.epam.tasks.task2.report.Report;
import com.epam.tasks.task2.service.DateService;

public class Main {

    public static void main(String[] args) {
        CustomDate date1 = new CustomDate(2, 2013);
        CustomDate date2 = new CustomDate(2, 2000);
        DateService dateService = new DateService();
        int days1 = dateService.determineDaysNumber(date1);
        date1.setDays(days1);
        int days2 = dateService.determineDaysNumber(date2);
        date2.setDays(days2);
        Report report = new Report();
        report.getReport(date1);
        report.getReport(date2);
    }
}
