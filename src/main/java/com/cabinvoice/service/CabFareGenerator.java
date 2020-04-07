package com.cabinvoice.service;

import com.cabinvoice.utility.CabInvoice;
import com.cabinvoice.utility.RideRepository;
import com.cabinvoice.utility.RideType;

public class CabFareGenerator {
    //CONSTANTS
    private static double DISTANCE_COST_PER_KILOMETER;
    private static int TRAVEL_COST_PER_MINUTE;
    private static double MINIMUM_TRAVEL_COST;

    //NEW OBJECT
    RideRepository rideRepository = new RideRepository();

    //CONSTRUCTOR
    public CabFareGenerator() {
        this.rideRepository = new RideRepository();
    }

    //METHOD TO GET FARE
    public double getFare(RideType rideType, double distance, int time) {
        setRideValue(rideType);
        double fare = distance * DISTANCE_COST_PER_KILOMETER + time * TRAVEL_COST_PER_MINUTE;
        return Math.max(MINIMUM_TRAVEL_COST, fare);
    }

    //METHOD FOR RIDE TYPE
    private void setRideValue(RideType rideType) {
        DISTANCE_COST_PER_KILOMETER = rideType.costPerKilometer;
        TRAVEL_COST_PER_MINUTE = rideType.costPerMinute;
        MINIMUM_TRAVEL_COST = rideType.minimumFare;
    }

    //METHOD TO GET INVOICE
    public CabInvoice getInvoice(String userId) {
        return invoiceGenerator(rideRepository.getRideList(userId));
    }

    //METHOD TO ADD RIDES
    public void addRides(String userId, Rides[] rides) {
        rideRepository.addRide(userId, rides);
    }

    //METHOD TO GENERATE INVOICE
    public CabInvoice invoiceGenerator(Rides[] multiRides) {
        double totalFare = 0;
        for (Rides rides : multiRides) {
            totalFare += getFare(rides.rideType, rides.cabServiceInDistance, rides.cabServiceInTime);
        }
        return new CabInvoice(multiRides.length, totalFare);
    }

    //MAIN METHOD
    public static void main(String[] args) {
    }
}