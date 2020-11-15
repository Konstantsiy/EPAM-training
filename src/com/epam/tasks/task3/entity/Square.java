package com.epam.tasks.task3.entity;

public class Square extends Figure {
    private double side;

    public Square() {
        super();
    }

    public Square(double side) {
        super(Math.pow(side, 2));
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }
}
