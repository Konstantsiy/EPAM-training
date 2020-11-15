package com.epam.tasks.task6.entity;

public class Time {
    private int hours;
    private int minutes;
    private int seconds;

    public Time() {};

    public Time(int seconds){
        if (seconds < 0) {
//            throw new DateTimeException("Parameters must be positive!");
        }
        this.seconds = seconds;
    }

    public Time(int hours, int minutes, int seconds) {
        if(hours < 0 || hours  > 24 || minutes < 0 || minutes > 59 || seconds < 0) {
//            throw new DateTimeException("Incorrect input parameters!");
        }
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    @Override
    public String toString() {
        return hours + ":" + minutes + ":" + seconds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Time time = (Time) o;
        return hours == time.hours &&
                minutes == time.minutes &&
                seconds == time.seconds;
    }
}
