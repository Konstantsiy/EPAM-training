package com.epam.tasks.task7.service;

import com.epam.tasks.task7.entity.Point;

public class PointService {

    public Point findClosesPoint(Point point1, Point point2){
        double distance1 = Math.hypot(point1.getX(), point1.getY());
        double distance2 = Math.hypot(point2.getX(), point2.getY());
        return distance1 > distance2 ? point2 : point1;
    }

    public Point findClosesPoint(Point[] points) {
        double min = Math.hypot(points[0].getX(), points[0].getY());
        Point nearestPoint = points[0];
        for(int i = 1; i < points.length; i++) {
            double distance = Math.hypot(points[i].getX(), points[i].getY());
            if(distance < min) {
                min = distance;
                nearestPoint = points[i];
            }
        }
        return nearestPoint;
    }
}
