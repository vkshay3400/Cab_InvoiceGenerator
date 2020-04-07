package com.cabinvoice;

public enum RideType {
    NORMAL_RIDES(10, 1, 5),
    PREMIUM_RIDES(15, 2, 20);

    public final double costPerKilometer;
    public final int costPerMinute;
    public final double minimumFare;

    RideType(double costPerKilometer, int costPerMinute, int minimumFare) {
        this.costPerKilometer = costPerKilometer;
        this.costPerMinute = costPerMinute;
        this.minimumFare = minimumFare;
    }
}