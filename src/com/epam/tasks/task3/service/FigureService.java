package com.epam.tasks.task3.service;

import com.epam.tasks.task3.entity.Circle;
import com.epam.tasks.task3.entity.Square;

public class FigureService {
    public double findInnerSquareArea(Circle outerCircle) {
        return Math.pow(outerCircle.getRadius() * 2, 2) / 2.0;
    }

    public double findInnerCircleRadius(Square outerSquare) {
        return outerSquare.getSide() / 2.0;
    }

}
