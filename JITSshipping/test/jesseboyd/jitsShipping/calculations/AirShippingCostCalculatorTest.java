package jesseboyd.jitsShipping.calculations;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import jesseboyd.jitsShipping.DemoParcelsForTesting;
import jesseboyd.jitsShipping.Parcel;
import jesseboyd.jitsShipping.calculations.AirShippingCostCalculator;

public class AirShippingCostCalculatorTest {

	private AirShippingCostCalculator asc;

	@Before
	public void setUp() throws Exception {
		@SuppressWarnings("unused")
		List<Parcel> parcels = DemoParcelsForTesting.getParcels();
		asc = new AirShippingCostCalculator(2, 25.2, 15.0); // zone, weight, volume
	}

	@Test
	public void calcAirCost() throws NoSuchMethodException, SecurityException {
		double actual = asc.calcCost();
		double expected = 1323.0;
		assertEquals(expected, actual, .01);
	}

	
	
}
