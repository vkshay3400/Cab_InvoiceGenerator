package com.cabinvoice;

public class Fare {
    //CONSTANTS
    public static final double DISTANCE_COST_PER_KM = 10;
    public static final double TRAVEL_COST_PER_MIN = 1;
    public static final int MINIMUM_TRAVEL_COST = 5;

    //METHOD TO GET TOTAL FARE
    public double getFare(Rides[] multiRides) {
        double fare = 0;
        for (Rides ride : multiRides)
            fare += ride.journeyInDistance * DISTANCE_COST_PER_KM + ride.journeyInTime * TRAVEL_COST_PER_MIN;
        return Math.max(MINIMUM_TRAVEL_COST, fare);
    }

    //METHOD TO GET INVOICE
    public Invoice getInvoice(Rides[] multiRides) {
        double totalFare = getFare(multiRides);
        return new Invoice(multiRides.length, totalFare);
    }

    //MAIN METHOD
    public static void main(String[] args) {
        System.out.println("Welcome to cab invoice");
    }
}