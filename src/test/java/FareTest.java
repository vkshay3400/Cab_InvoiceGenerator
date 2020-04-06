import com.cabinvoice.Fare;
import com.cabinvoice.Invoice;
import com.cabinvoice.Rides;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FareTest {
    Fare fare = null;

    @Before
    public void setFare() throws Exception {
        fare = new Fare();
    }

    @Test
    public void givenDistanceAndTime_ShouldReturnFare_ForJourney() {
        Rides[] rides = {new Rides(10.43, 27)};
        double totalFare = fare.getFare(rides);
        Assert.assertEquals(131.3, totalFare, 0.0);
    }

    @Test
    public void givenDistanceAndTime_ShouldReturnMinimumFare_ForJourney() {
        Rides[] rides = {new Rides(0.3, 1)};
        double totalFare = fare.getFare(rides);
        Assert.assertEquals(5, totalFare, 0.0);
    }

    @Test
    public void givenMultipleRides_ShouldReturnTotalFare_ForJourney() {
        Rides[] rides = {new Rides(40.2, 23),
                         new Rides(5.9, 10)
        };
        double totalFare = fare.getFare(rides);
        Assert.assertEquals(494.0, totalFare, 0.0);
    }

    @Test
    public void givenMultipleRides_ShouldReturnInvoice_ForJourney() {
        Rides[] rides = {new Rides(40.2, 23),
                         new Rides(5.9, 10)
        };
        Invoice invoiceActual = fare.getInvoice(rides);
        Invoice invoiceExpected = new Invoice(2, 494.0);
        Assert.assertEquals(invoiceExpected, invoiceActual);
    }

    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummary_ForJourney() {
        Rides[] rides = {new Rides(40.2, 23),
                         new Rides(5.9, 10),
                         new Rides(27.0, 19),
                         new Rides(45.5, 34),
        };
        fare.addRides("user1", rides);
        Invoice invoiceActual = fare.getInvoice(rides);
        Invoice invoiceExpected = new Invoice(4, 1272.0);
        Assert.assertEquals(invoiceExpected, invoiceActual);
    }
}