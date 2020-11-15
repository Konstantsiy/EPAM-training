package com.epam.tasks.task3.service;

import com.epam.tasks.task3.entity.Circle;
import com.epam.tasks.task3.entity.Square;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class FigureServiceTest {
    FigureService figureService = new FigureService();

    @Test
    public void testFindInnerSquareArea() {
        Circle circle = new Circle(8);
        double innerSquareArea = figureService.findInnerSquareArea(circle);
        Assert.assertEquals((int)innerSquareArea, 128);
    }

    @Test
    public void testFindInnerCircleRadius() {
        Square square = new Square(4);
        double innerCircleRadius = figureService.findInnerCircleRadius(square);
        Assert.assertEquals((int)innerCircleRadius, 2);
    }
}