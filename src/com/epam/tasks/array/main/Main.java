package com.epam.tasks.array.main;

import com.epam.tasks.array.entity.IntArray;
import com.epam.tasks.array.exception.ArrayCreationException;
import com.epam.tasks.array.exception.ArrayServiceException;
import com.epam.tasks.array.service.ArrayService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Main {

    public static final Logger logger = LogManager.getLogger(Math.class);

    public static void main(String[] args)  {
        try {
            IntArray array = new IntArray(10);
            logger.info("Array creation successful");
            array.randomFilling(0, 100);
            logger.info("The array was filled with random");
            ArrayService arrayService = new ArrayService();
            array = arrayService.insertionSort(array);
            logger.info("Array was sorted by inserts");
            if (arrayService.binarySearch(array, 20) != -1) {
                logger.info("Array contains needed number");
            } else {
                logger.info("Array doesn't contain needed number");
            }
            System.out.print(array);
        } catch (ArrayCreationException | ArrayServiceException e) {
            logger.error(e.getMessage());
        }
    }
}
