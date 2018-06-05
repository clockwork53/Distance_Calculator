package com.clockwork53.distancecalculator;

import android.location.Location;


/**
 * Created by Mohammad on 5/22/2018.
 */

public class distanceCalc {

    private Location Origin,Destination;

    public distanceCalc()
    {
        Origin = new Location("dummy");
        Destination = new Location("dummy");
    }

    public Float calculateDistance(Double OrgLa,Double OrgLo,Double DesLa,Double DesLo)
    {

        Origin.setLatitude(OrgLa);
        Origin.setLongitude(OrgLo);
        Destination.setLatitude(DesLa);
        Destination.setLongitude(DesLo);

        float Distance = Origin.distanceTo(Destination);
        return Distance;
    }
}
