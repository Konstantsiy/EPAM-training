package com.epam.tasks.task1.service;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ComputingServiceTest {

    @Test
    public void testDetermineLastSquareDigit() {
        ComputingService computingService = new ComputingService();
        Assert.assertEquals(computingService.determineLastSquareDigit(0), 0);
        Assert.assertEquals(computingService.determineLastSquareDigit(1232), 4);
        Assert.assertEquals(computingService.determineLastSquareDigit(-369), 1);
    }
}