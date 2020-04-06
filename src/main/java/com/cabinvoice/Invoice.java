package com.cabinvoice;

import java.util.Objects;

public class Invoice {
    public int NumberOfRides;
    public double totalFare;
    public double averageFarePerRides;

    public Invoice(int NumberOfRides, double totalFare) {
        this.NumberOfRides = NumberOfRides;
        this.totalFare = totalFare;
        this.averageFarePerRides = (totalFare / NumberOfRides);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return NumberOfRides == invoice.NumberOfRides &&
                Double.compare(invoice.totalFare, totalFare) == 0 &&
                Double.compare(invoice.averageFarePerRides, averageFarePerRides) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(NumberOfRides, totalFare, averageFarePerRides);
    }
}
