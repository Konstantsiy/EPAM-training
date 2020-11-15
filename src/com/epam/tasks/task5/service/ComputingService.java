package com.epam.tasks.task5.service;

public class ComputingService {

    public boolean isPerfect(int number) {
        int sum = 0;
        for(int i = 1; i < number; i++) {
            if(number % i == 0) {
                sum += i;
            }
        }
        return number == sum;
    }
}
