package com.epam.tasks.library.util;

public class IdCounter {
    private static IdCounter instance;
    private static int counter;

    private IdCounter(){
        counter = 0;
    }

    public static IdCounter getInstance() {
        if(instance == null) {
            instance = new IdCounter();
        }
        return instance;
    }

    public static int getNext() {
        return ++counter;
    }
}
