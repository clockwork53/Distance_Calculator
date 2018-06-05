package com.clockwork53.distancecalculator;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 * Created by Mohammad on 5/22/2018.
 */
public class distanceCalcTest {

    private static final float DELTA = (float)10.0;   //defines the maximum acceptable error
    private distanceCalc distanceCalcInstance;
    private double a,b,c,d,e;

    @Before
    public void setUp()  {
        a = 35.6892;        //latitude of Tehran
        b = 51.3890;        //longitude of Tehran

        c = 29.5918;        //latitude of Shiraz
        d = 52.5837;        //latitude of Shiraz

        e = 685400.0;       //distance between tehran and shiraz in meters
        distanceCalcInstance = new distanceCalc();
    }

    @After
    public void tearDown()  {
        distanceCalcInstance = null;
    }

    @Test
    public void calculateDistance()  {
        double actual = distanceCalcInstance.calculateDistance(a,b,c,d);
        Assert.assertEquals(e,actual,DELTA);
    }

}