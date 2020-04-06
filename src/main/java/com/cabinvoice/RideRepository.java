package com.cabinvoice;

import java.util.HashMap;
import java.util.Map;

public class RideRepository {
    Map<String, Rides[]> rideList;

    public RideRepository(){
        this.rideList = new HashMap<>();
    }

    public void addRide(String userId, Rides[] rides){
        rideList.put(userId, rides);
    }

    public Rides[] getRideList (String userId){
        return rideList.get(userId);
    }
}