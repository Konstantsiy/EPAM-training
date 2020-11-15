package com.epam.tasks.task3.entity;

public abstract class Figure {
    private double area;

    protected Figure() {}

    protected Figure(double area) {
        if(area < 0) {
//            throw new FigureException("Figure area must be positive!");
        }
        this.area = area;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }
}
