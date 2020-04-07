package com.cabinvoice.utility;

import com.cabinvoice.service.Rides;

import java.util.*;

public class RideRepository {
    Map<String, ArrayList<Rides>> ridesOfUser = null;

    public RideRepository() {
        this.ridesOfUser = new HashMap<>();
    }

    public void addRide(String userId, Rides[] rides) {
        ArrayList<Rides> ridesList = this.ridesOfUser.get(userId);
        if (ridesList == null) {
            this.ridesOfUser.put(userId, new ArrayList<>((Arrays.asList(rides))));
        }
    }

    public Rides[] getRideList(String userId) {
        return ridesOfUser.get(userId).toArray(new Rides[0]);
    }
}