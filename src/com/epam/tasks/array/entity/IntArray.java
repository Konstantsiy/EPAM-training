package com.epam.tasks.array.entity;

import com.epam.tasks.array.exception.ArrayCreationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class IntArray {
    private static final Logger logger = LogManager.getLogger(IntArray.class);
    private int[] ms;

    public IntArray() {
        this.ms = new int[0];
    }

    public IntArray(int length) throws ArrayCreationException {
        if(length >= 0) {
            logger.info("Creating new array");
            this.ms = new int[length];
        } else {
            logger.error("Array length is negative");
            throw new ArrayCreationException("Array size cannot be negative");
        }
    }

    public IntArray(int[] ms) {
        this.ms = ms;
    }

    public int[] getMs() {
        return ms;
    }

    public void setMs(int[] ms) throws ArrayCreationException {
        if(ms != null) {
            this.ms = ms;
        } else {
          throw new ArrayCreationException("Can't set empty array as a field");
        }
    }

    public int getLength() {
        return ms.length;
    }

    public void setLength(int newLength) throws ArrayCreationException {
        if(newLength >= 0) {
             if(ms.length > newLength){
                 int[] newMs = new int[newLength];
                 System.arraycopy(ms, 0, newMs, 0, newLength);
                 this.ms = newMs;
             }
             if(ms.length < newLength) {
                 int[] newMs = new int[newLength];
                 System.arraycopy(ms, 0, newMs, 0, ms.length);
                 for(int i = ms.length; i < newLength; i++) {
                     newMs[i] = 0;
                 }
                 this.ms = newMs;
             }
        } else {
            throw new ArrayCreationException("Can't set negative length");
        }
    }

    public void add(int number) {
        ms = Arrays.copyOf(ms, ms.length + 1);
        ms[ms.length - 1] = number;
    }

    public boolean isEmpty() {
        return ms.length == 0;
    }

    public boolean isSorted() {
        for(int i = 1; i < ms.length; i++) {
            if(ms[i - 1] > ms[i]) {
                return false;
            }
        }
        return true;
    }

    public void randomFilling(int left, int right) throws ArrayCreationException {
        if (left < right) {
            if (ms.length != 0) {
                for (int i = 0; i < ms.length; i++) {
                    ms[i] = (int)((Math.random() * (right - left)) + left);
                }
            }
        } else {
            throw new ArrayCreationException("The left border of the random should be smaller than the right");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntArray array = (IntArray) o;
        return Arrays.equals(ms, array.ms);
    }

    @Override
    public int hashCode() {
        return 31 * 17 + Arrays.hashCode(ms);
    }

    @Override
    public String toString() {
        return Arrays.toString(ms);
    }
}
