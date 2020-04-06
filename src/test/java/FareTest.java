import com.cabinvoice.Fare;
import org.junit.Assert;
import org.junit.Test;

public class FareTest {
    Fare fare = new Fare();

    @Test
    public void givenDistanceANdTime_ShouldReturnFareForJourney() {
        double totalFare = fare.getFare(15, 14);
        Assert.assertEquals(164, totalFare, 0);
    }

    @Test
    public void givenDistanceANdTime_ShouldReturnMinimumFareForJourney() {
        double totalFare = fare.getFare(0.3, 1);
        Assert.assertEquals(5, totalFare, 0);
    }
}