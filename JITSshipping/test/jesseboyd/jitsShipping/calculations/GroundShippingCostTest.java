package jesseboyd.jitsShipping.calculations;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import jesseboyd.jitsShipping.DemoParcelsForTesting;
import jesseboyd.jitsShipping.Parcel;
import jesseboyd.jitsShipping.calculations.GroundShippingCostCalculator;
import jesseboyd.jitsShipping.deliveryMethods.Ground;

public class GroundShippingCostTest {

	private GroundShippingCostCalculator gscc,gscc2;

	@Before
	public void setUp() throws Exception {
		// test parcels
		// 0-BA zone (1,9), 1-BG (3,3), 2-LAP (1,9), 3-LGW (1,9) no discount, 4-LGF (9,9)
		List<Parcel> parcels = DemoParcelsForTesting.getParcels();
		gscc = new GroundShippingCostCalculator((Ground) parcels.get(1).getDeliveryMethod(), 2.0);
		gscc2 = new GroundShippingCostCalculator((Ground) parcels.get(3).getDeliveryMethod(), 4.0);
	}

	@Test
	public void calculateGroundShippingCost() {
		assertEquals(0.13, gscc.calcCost(), .01);
		assertEquals(0.83, gscc2.calcCost(), .01);
	}
	
	@Test
	public void discountNotApplied() throws Exception {
		gscc.calcCost();
	assertTrue(gscc.isDiscounted());	
	assertFalse(gscc2.isDiscounted());	
	}

}
