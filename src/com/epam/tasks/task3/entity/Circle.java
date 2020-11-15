package com.epam.tasks.task3.entity;

public class Circle extends Figure {
    private double radius;

    public Circle() {
        super();
    }

    public Circle(double radius) {
        super(Math.PI * Math.pow(radius, 2));
        this.radius = radius;
    }


    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
