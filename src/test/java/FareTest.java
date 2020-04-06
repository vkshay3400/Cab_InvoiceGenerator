import com.cabinvoice.Fare;
import org.junit.Assert;
import org.junit.Test;

public class FareTest {
    Fare fare = new Fare();

    @Test
    public void givenDistanceANdTime_ShouldReturnFareForJourney() {
        double totalFare = fare.getFare(15, 14);
        Assert.assertEquals(290, totalFare, 0);
    }
}