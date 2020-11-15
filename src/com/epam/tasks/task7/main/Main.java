package com.epam.tasks.task7.main;

import com.epam.tasks.task7.entity.Point;
import com.epam.tasks.task7.report.Report;
import com.epam.tasks.task7.service.PointService;

public class Main {

    public static void main(String[] args){
        Point point1 = new Point(7, 23);
        Point point2 = new Point(-2, -5);
        PointService pointService = new PointService();
        Report report = new Report();
        report.getReport(pointService.findClosesPoint(point1, point2));
    }
}
