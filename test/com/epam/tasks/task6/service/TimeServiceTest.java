package com.epam.tasks.task6.service;

import com.epam.tasks.task6.entity.Time;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TimeServiceTest {

    @Test
    public void testConvertSeconds() {
        Time time = new Time(23, 34, 59);
        int seconds = 84899;
        TimeService timeService = new TimeService();
        Time resultTime = timeService.convertSeconds(seconds);
        Assert.assertEquals(time, resultTime);
    }
}