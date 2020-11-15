package com.epam.tasks.task2.entity;

public class CustomDate {
    private int years;
    private int months;
    private int days;

    public CustomDate(int month, int year) {
        if(year <= 0 || month <= 0 || month > 12) {
//            throw new DateTimeException("Parameters must be positive");
        }
        this.years = year;
        this.months = month;
        this.days = 0;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public int getMonths() {
        return months;
    }

    public void setMonths(int months) {
        this.months = months;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    @Override
    public String toString() {
        return days + "." + months + "." + "." + years;
    }
}
