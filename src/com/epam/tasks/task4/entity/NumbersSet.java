package com.epam.tasks.task4.entity;

import java.util.Arrays;

public class NumbersSet {
    private int[] ms;
    private boolean flag;

    public NumbersSet(int border) {
        this.flag = false;
        ms = new int[4];
        for(int i = 0; i < ms.length; i++) {
            ms[i] = (int)(Math.random() * border);
        }
    }

    public NumbersSet(int[] ms) {
        this.ms = ms;
    }

    public int[] getMs() {
        return ms;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return Arrays.toString(ms) + " " + flag;
    }
}
