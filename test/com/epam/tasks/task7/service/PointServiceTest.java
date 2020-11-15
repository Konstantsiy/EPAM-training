package com.epam.tasks.task7.service;

import com.epam.tasks.task7.entity.Point;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class PointServiceTest {

    @Test
    public void testFindClosesPoint() {
        Point p1 = new Point(4, 5);
        Point p2 = new Point(6, 7);
        Point p3 = new Point(-2, -4);
        Point points[] = {p1, p2, p3};
        PointService pointService = new PointService();

        Point actual1 = pointService.findClosesPoint(p1, p2);
        Assert.assertEquals(p1, actual1);

        Point actual2 = pointService.findClosesPoint(points);
        Assert.assertEquals(p3, actual2);
    }
}