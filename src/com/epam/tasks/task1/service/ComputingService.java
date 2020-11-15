package com.epam.tasks.task1.service;

public class ComputingService {

    public int determineLastSquareDigit(int number) {
        if(Math.abs(number) >= 10) {
            number %= 10;
        }
        switch(Math.abs(number)){
            case 1:
            case 9: return 1;
            case 2:
            case 8: return 4;
            case 3:
            case 7: return 9;
            case 4:
            case 6: return 6;
            case 5: return 5;
            default: return 0;
        }
    }
}
