package jesseboyd.jitsShipping.calculations;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import jesseboyd.jitsShipping.DemoParcelsForTesting;
import jesseboyd.jitsShipping.calculations.AirShippingCostCalculator;
import jesseboyd.jitsShipping.deliveryMethods.Air;
import jesseboyd.jitsShipping.parcels.Parcel;

public class AirShippingCostCalculatorTest {

	private AirShippingCostCalculator asc;

	@Before
	public void setUp() throws Exception {
		@SuppressWarnings("unused")
		List<Parcel> parcels = DemoParcelsForTesting.getParcels();
		// test parcels
		// 0-BA zone (1,9), 1-BG (3,3), 2-LAP (1,9), 3-LGW no discount (1,9), 4-LGF (9,9)
		asc = new AirShippingCostCalculator((Air) parcels.get(0).getDeliveryMethod(), 25.2, 15.0); // Air, weight, volume
	}

	@Test
	public void calcAirCost() throws NoSuchMethodException, SecurityException {
		double actual = asc.calcCost();
		double expected = 330.75;
		assertEquals(expected, actual, .01);
	}

	
	
}
