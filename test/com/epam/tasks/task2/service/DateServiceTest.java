package com.epam.tasks.task2.service;

import com.epam.tasks.task2.entity.CustomDate;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class DateServiceTest {

    @Test
    public void testDetermineDaysNumber() {
        CustomDate date1 = new CustomDate(12, 1978);
        CustomDate date2 = new CustomDate(2, 2013);
        CustomDate date3 = new CustomDate(2, 2000);
        DateService dateService = new DateService();
        Assert.assertEquals(dateService.determineDaysNumber(date1), 31);
        Assert.assertEquals(dateService.determineDaysNumber(date2), 28);
        Assert.assertEquals(dateService.determineDaysNumber(date3), 29);
    }
}