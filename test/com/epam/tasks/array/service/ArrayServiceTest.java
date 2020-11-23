package com.epam.tasks.array.service;

import com.epam.tasks.array.entity.IntArray;
import com.epam.tasks.array.exception.ArrayCreationException;
import com.epam.tasks.array.exception.ArrayServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class ArrayServiceTest {
    private static final Logger logger = LogManager.getLogger(ArrayService.class);
    private final ArrayService arrayService = new ArrayService();
    private IntArray array;

    @BeforeMethod
    public void setUp() throws ArrayCreationException {
        array = new IntArray(10);
        array.randomFilling(-20, 20);
        logger.info("The array was filled with random");
    }

    @Test
    public void testSort() {
        IntArray array1 = arrayService.bubbleSort(array);
        IntArray array2 = arrayService.insertionSort(array);
        IntArray array3 = arrayService.shellSort(array);
        Assert.assertEquals(array1, array2);
        Assert.assertEquals(array2, array3);
        logger.info("The sorts worked correctly");
    }

    @Test
    public void testBinarySearch() {
        array.add(30);
        try {
           Assert.assertEquals(arrayService.binarySearch(array, 30), 21);
           Assert.assertEquals(arrayService.binarySearch(array, -40), -1);
           logger.info("Binary search worked correctly");
        } catch (ArrayServiceException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFindMin() {
        array.add(-50);
        try {
            Assert.assertEquals(arrayService.findMin(array), -50);
        } catch (ArrayServiceException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFindMax() {
        array.add(100);
        try {
            Assert.assertEquals(arrayService.findMax(array), 100);
        } catch (ArrayServiceException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFindAllPrimeNumbers() {
        IntArray testArray = new IntArray();
        testArray.add(3);
        testArray.add(17);
        testArray.add(23);
        IntArray result = new IntArray(new int[]{3, 17, 23});
        Assert.assertEquals(arrayService.findAllPrimeNumbers(testArray), result);
    }

    @Test
    public void testFindAllFibonacciNumbers() {
        IntArray testArray = new IntArray();
        testArray.add(34);
        testArray.add(89);
        testArray.add(144);
        try {
            Assert.assertEquals(arrayService.findAllFibonacciNumbers(testArray), testArray);
        } catch (ArrayServiceException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFindAll3DigitUniqueNumbers() {
        IntArray testArray = new IntArray();
        testArray.add(99);
        testArray.add(123);
        testArray.add(223);
        testArray.add(456);
        testArray.add(2345);
        IntArray result = new IntArray(new int[]{123, 456});
        try {
            Assert.assertEquals(arrayService.findAll3DigitUniqueNumbers(testArray), result);
        } catch (ArrayServiceException e) {
            e.printStackTrace();
        }

    }
}