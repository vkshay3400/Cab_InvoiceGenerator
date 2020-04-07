package com.cabinvoice;

public class Rides {
    public double cabServiceInDistance;
    public int cabServiceInTime;
    RideType rideType;

    public Rides(RideType rideType, double cabServiceInDistance, int cabServiceInTime) {
        this.rideType = rideType;
        this.cabServiceInDistance = cabServiceInDistance;
        this.cabServiceInTime = cabServiceInTime;
    }
}