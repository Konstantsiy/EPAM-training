package com.epam.tasks.task4.service;

import com.epam.tasks.task4.entity.NumbersSet;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ComputingServiceTest {

    @Test
    public void testCheckSet() {
        ComputingService computingService = new ComputingService();
        int ms1[] = {12, 35, 24, 167};
        NumbersSet set = new NumbersSet(ms1);
        Assert.assertTrue(computingService.checkSet(set));
    }
}