package com.cabinvoice;

public class Fare {
    //CONSTANTS
    public static final double DISTANCE_COST_PER_KM = 10;
    public static final double TRAVEL_COST_PER_MIN = 1;
    public static final int MINIMUM_TRAVEL_COST = 5;

    //METHOD TO GET FARE
    public double getFare(double distancePerKm, int travelTimeMin){
        double fare = distancePerKm * DISTANCE_COST_PER_KM + travelTimeMin * TRAVEL_COST_PER_MIN;
        return Math.max(MINIMUM_TRAVEL_COST, fare);
    }

    //MAIN METHOD
    public static void main(String[] args) {
        System.out.println("Welcome to cab invoice");
    }
}
