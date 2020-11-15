package com.epam.tasks.task3.main;

import com.epam.tasks.task3.entity.Circle;
import com.epam.tasks.task3.entity.Square;
import com.epam.tasks.task3.report.Report;
import com.epam.tasks.task3.service.FigureService;

public class Main {

    public static void main(String[] args) {
        Square square = new Square(4);
        Circle innerCircle = new Circle();
        FigureService figureService = new FigureService();
        innerCircle.setRadius(figureService.findInnerCircleRadius(square));
        Square innerSquare = new Square();
        innerSquare.setArea(figureService.findInnerSquareArea(innerCircle));
        Report report = new Report();
        report.getReport(innerSquare);
    }
}
