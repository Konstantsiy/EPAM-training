package com.epam.tasks.task6.service;

import com.epam.tasks.task6.entity.Time;

public class TimeService  {

    public Time convertSeconds(int seconds) {
        Time time = new Time();
        time.setHours(seconds / 3600);
        time.setMinutes((seconds - time.getHours() * 3600) / 60);
        time.setSeconds(seconds - time.getHours() * 3600 - time.getMinutes() * 60);
        return time;
    }
}
