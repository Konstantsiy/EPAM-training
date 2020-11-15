package com.epam.tasks.task4.service;

import com.epam.tasks.task4.entity.NumbersSet;

public class ComputingService{

    public boolean checkSet(NumbersSet set) {
        int count = 0;
        for(int i : set.getMs()) {
            if(i % 2 == 0) {
                count++;
            }
        }
        return count >= 2;
    }
}
