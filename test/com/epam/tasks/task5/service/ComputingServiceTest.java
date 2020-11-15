package com.epam.tasks.task5.service;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ComputingServiceTest {

    @Test
    public void testIsPerfect() {
        ComputingService computingService = new ComputingService();
        Assert.assertFalse(computingService.isPerfect(17));
        Assert.assertTrue(computingService.isPerfect(28));
    }
}