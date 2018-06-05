package com.clockwork53.distancecalculator;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 * Created by Mohammad on 5/22/2018.
 */
public class distanceCalcTest {

    private static final float DELTA = (float)10.0;
    private distanceCalc distanceCalcInstance;
    private double a,b,c,d;

    @Before
    public void setUp()  {
        a = 35.6892;
        b = 51.3890;

        c = 29.5918;
        d = 52.5837;
        distanceCalcInstance = new distanceCalc();
    }

    @After
    public void tearDown()  {
        distanceCalcInstance = null;
    }

    @Test
    public void calculateDistance()  {
        float actual = distanceCalcInstance.calculateDistance(a,b,c,d);
        Assert.assertEquals(685400.0,actual,DELTA);
    }

}