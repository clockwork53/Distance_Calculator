package com.clockwork53.distancecalculator;

import android.location.Location;


/**
 * Created by Mohammad on 5/22/2018.
 */

public class distanceCalc {

    private Location Origin,Destination;

    /**
     * constructor defines two Location data types provided by a dummy variable
     */
    distanceCalc()
    {
        Origin = new Location("dummy");
        Destination = new Location("dummy");
    }

    /**
     *
     * @param OrgLa Origin latitude
     * @param OrgLo Origin longitude
     * @param DesLa Destination latitude
     * @param DesLo Destination longitude
     * @return distance between to locations
     */
    public Float calculateDistance(Double OrgLa,Double OrgLo,Double DesLa,Double DesLo)
    {

        Origin.setLatitude(OrgLa);
        Origin.setLongitude(OrgLo);
        Destination.setLatitude(DesLa);
        Destination.setLongitude(DesLo);

        return Origin.distanceTo(Destination);
    }
}
