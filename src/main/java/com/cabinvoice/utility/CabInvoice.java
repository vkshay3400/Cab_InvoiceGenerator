package com.cabinvoice.utility;

import java.util.Objects;

public class CabInvoice {
    public int numberOfRides;
    public double totalFare;
    public double averageFarePerRides;

    public CabInvoice(int NumberOfRides, double totalFare) {
        this.numberOfRides = NumberOfRides;
        this.totalFare = totalFare;
        this.averageFarePerRides = (totalFare / NumberOfRides);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CabInvoice cabInvoice = (CabInvoice) o;
        return numberOfRides == cabInvoice.numberOfRides &&
                Double.compare(cabInvoice.totalFare, totalFare) == 0 &&
                Double.compare(cabInvoice.averageFarePerRides, averageFarePerRides) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfRides, totalFare, averageFarePerRides);
    }
}