package com.epam.tasks.task2.service;

import com.epam.tasks.task2.entity.CustomDate;

public class DateService {

    public int determineDaysNumber(CustomDate date) {
        switch(date.getMonths()) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12: return 31;
            case 2:
                int year = date.getYears();
                if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) return 29;
                else return 28;
            case 4:
            case 6:
            case 9:
            case 11: return 30;
            default: return 0;
        }
    }
}
