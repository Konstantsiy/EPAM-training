package com.epam.tasks.array.service;

import com.epam.tasks.array.entity.IntArray;
import com.epam.tasks.array.exception.ArrayServiceException;

public class ArrayService {

    public ArrayService() {}

    public IntArray shellSort(IntArray array) {
        int[] ms = array.getMs();
        int length = ms.length;
        int i, j, temp, step;
        for(step = length / 2; step > 0; step /= 2) {
            for(i = step; i < length; i++) {
                temp = ms[i];
                for(j = i; j >= step; j -= step) {
                    if(temp < ms[j - step]) {
                        ms[j] = ms[j - step];
                    } else break;
                }
                ms[j] = temp;
            }
        }
        return new IntArray(ms);
    }

    public IntArray bubbleSort(IntArray array) {
        int[] ms = array.getMs();
        for(int i = 0; i < ms.length - 1; i++) {
            for(int j = ms.length - 1; j > i; j--) {
                if(ms[j - 1] > ms[j]) {
                    int temp = ms[j - 1];
                    ms[j - 1] = ms[j];
                    ms[j] = temp;
                }
            }
        }
        return new IntArray(ms);
    }

    public IntArray insertionSort(IntArray array) {
        int[] ms = array.getMs();
        for (int i = 1; i < ms.length; i++) {
            int current = ms[i];
            int j = i - 1;
            while(j >= 0 && current < ms[j]) {
                ms[j+1] = ms[j];
                j--;
            }
            ms[j+1] = current;
        }
        return new IntArray(ms);
    }

    public int binarySearch(IntArray array, int key) throws ArrayServiceException {
        if(array.isEmpty()) {
            throw new ArrayServiceException("Array must not be empty");
        }
        if(!array.isSorted()){
            throw new ArrayServiceException("The array must be sorted before binary search");
        }
        int[] ms = array.getMs();
        int left = ms[0];
        int right = ms[ms.length - 1];
        int index = -1;
        while(left < right) {
            int middle = (left + right) / 2;
            if(ms[middle] < key) {
                left = middle + 1;
            } else if(ms[middle] > key) {
                right = middle - 1;
            } else if(ms[middle] == key) {
                index = middle;
                break;
            }
        }
        return index;
    }

    public int findMin(IntArray array) throws ArrayServiceException {
        if(!array.isEmpty()) {
            int[] ms = array.getMs();
            int min = ms[0];
            for(int i = 1; i < ms.length; i++) {
                if(ms[i] < min) {
                    min = ms[i];
                }
            }
            return min;
        } else {
            throw new ArrayServiceException("Array must not be empty");
        }
    }

    public int findMax(IntArray array) throws ArrayServiceException {
        if(!array.isEmpty()) {
            int[] ms = array.getMs();
            int max = ms[0];
            for(int i = 1; i < ms.length; i++) {
                if(ms[i] > max) {
                    max = ms[i];
                }
            }
            return max;
        } else {
            throw new ArrayServiceException("Array must not be empty");
        }
    }

    public IntArray findAllPrimeNumbers(IntArray array) {
        IntArray primeNumbers = new IntArray();
        for(int number : array.getMs()) {
            for(int i = 2; i <= Math.sqrt(number); i++) {
                if(number % i == 0) {
                    break;
                }
            }
            primeNumbers.add(number);
        }
        return primeNumbers;
    }

    public IntArray findAllFibonacciNumbers(IntArray array) throws ArrayServiceException {
        if(!array.isEmpty()) {
            IntArray fibonacciNumbers = new IntArray();
            for(int number : array.getMs()) {
                int previous = 1;
                int current = 1;
                while(current < number) {
                    int temp = current;
                    current += previous;
                    previous = temp;
                }
                if(number == current) {
                    fibonacciNumbers.add(number);
                }
            }
            return fibonacciNumbers;
        } else {
            throw new ArrayServiceException("Array must not be empty");
        }

    }

    public IntArray findAll3DigitUniqueNumbers(IntArray array) throws ArrayServiceException {
        if(!array.isEmpty()) {
            IntArray uniqueNumbers = new IntArray();
            for(int number : array.getMs()) {
                if(number > 99 && number < 1000) {
                    String str = String.valueOf(number);
                    boolean flag = true;
                    for(int i = 0; i < str.length(); i++) {
                        for(int j = 0; j < str.length(); j++) {
                            if(j != i) {
                                if(str.charAt(i) == str.charAt(j)) {
                                    flag = false;
                                    break;
                                }
                            }
                        }
                        if(!flag) break;
                    }
                    if(flag) uniqueNumbers.add(number);
                }
            }
            return uniqueNumbers;
        } else {
            throw new ArrayServiceException("Array must not be empty");
        }
    }
 }
