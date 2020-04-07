package com.cabinvoice;

import com.cabinvoice.service.CabFareGenerator;
import com.cabinvoice.service.Rides;
import com.cabinvoice.utility.CabInvoice;
import com.cabinvoice.utility.RideType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CabFareGeneratorTest {
    CabFareGenerator fare;
    double totalFare;

    @Before
    public void setFare() throws Exception {
        fare = new CabFareGenerator();
    }

    @Test
    public void givenDistanceAndTime_NormalRides_ShouldReturnFare_ForJourney() {
        totalFare = fare.getFare(RideType.NORMAL_RIDES, 10.43, 27);
        Assert.assertEquals(131.3, totalFare, 0.0);
    }

    @Test
    public void givenDistanceAndTime_PremiumRides_ShouldReturnFare_ForJourney() {
        totalFare = fare.getFare(RideType.PREMIUM_RIDES, 10.43, 27);
        Assert.assertEquals(210.45, totalFare, 0.0);
    }

    @Test
    public void givenDistanceAndTime_NormalRides_ShouldReturnMinimumFare_ForJourney() {
        totalFare = fare.getFare(RideType.NORMAL_RIDES, 0.3, 1);
        Assert.assertEquals(5, totalFare, 0.0);
    }

    @Test
    public void givenDistanceAndTime_PremiumRides_ShouldReturnMinimumFare_ForJourney() {
        totalFare = fare.getFare(RideType.PREMIUM_RIDES, 0.3, 1);
        Assert.assertEquals(20, totalFare, 0.0);
    }

    @Test
    public void givenMultipleRides_NormalRides_ShouldReturnTotalFare_ForJourney() {
        Rides[] rides = {new Rides(RideType.NORMAL_RIDES, 40.2, 23),
                         new Rides(RideType.NORMAL_RIDES, 5.9, 10)
                        };
        CabInvoice cabInvoice = fare.invoiceGenerator(rides);
        Assert.assertEquals(494.0, cabInvoice.totalFare, 0.0);
    }

    @Test
    public void givenMultipleRides_PremiumRides_ShouldReturnTotalFare_ForJourney() {
        Rides[] rides = {new Rides(RideType.PREMIUM_RIDES, 40.2, 23),
                         new Rides(RideType.PREMIUM_RIDES, 5.9, 10)
                        };
        CabInvoice cabInvoice = fare.invoiceGenerator(rides);
        Assert.assertEquals(757.5, cabInvoice.totalFare, 0.0);
    }

    @Test
    public void givenMultipleRides_NormalRides_ShouldReturnInvoice_ForJourney() {
        String userId = "ABC";
        Rides[] rides = {new Rides(RideType.NORMAL_RIDES, 40.2, 23),
                         new Rides(RideType.NORMAL_RIDES, 5.9, 10)
                        };
        fare.addRides(userId, rides);
        CabInvoice cabInvoiceActual = fare.getInvoice(userId);
        CabInvoice cabInvoiceExpected = new CabInvoice(2, 494.0);
        Assert.assertEquals(cabInvoiceExpected, cabInvoiceActual);
    }

    @Test
    public void givenMultipleRides_PremiumRides_ShouldReturnInvoice_ForJourney() {
        String userId = "ABC";
        Rides[] rides = {new Rides(RideType.PREMIUM_RIDES, 40.2, 23),
                         new Rides(RideType.PREMIUM_RIDES, 5.9, 10)
                        };
        fare.addRides(userId, rides);
        CabInvoice cabInvoiceActual = fare.getInvoice(userId);
        CabInvoice cabInvoiceExpected = new CabInvoice(2, 757.5);
        Assert.assertEquals(cabInvoiceExpected, cabInvoiceActual);
    }

    @Test
    public void givenMultipleRides_NormalPremiumRides_ShouldReturnInvoice_ForJourney() {
        String userId = "ABC";
        Rides[] rides = {new Rides(RideType.NORMAL_RIDES, 40.2, 23),
                         new Rides(RideType.PREMIUM_RIDES, 5.9, 10),
                         new Rides(RideType.NORMAL_RIDES, 27.0, 19),
                         new Rides(RideType.PREMIUM_RIDES, 45.5, 34),
                        };
        fare.addRides(userId, rides);
        CabInvoice cabInvoiceActual = fare.getInvoice(userId);
        CabInvoice cabInvoiceExpected = new CabInvoice(4, 1573);
        Assert.assertEquals(cabInvoiceExpected, cabInvoiceActual);
    }
}