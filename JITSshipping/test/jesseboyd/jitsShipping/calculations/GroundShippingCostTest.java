package jesseboyd.jitsShipping.calculations;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import jesseboyd.jitsShipping.calculations.GroundShippingCostCalculator;

public class GroundShippingCostTest {

	private GroundShippingCostCalculator gscc,gscc2;

	@Before
	public void setUp() throws Exception {
		gscc = new GroundShippingCostCalculator(2, 100, "PT", "MT");
		gscc2 = new GroundShippingCostCalculator(1, 100, "PT", "PT");
	}

	@Test
	public void calculateGroundShippingCost() {
		assertEquals(220, gscc.calcCost(), .01);
	}
	
	@Test
	public void discountNotApplied() throws Exception {
		gscc.calcCost();
	assertFalse(gscc.isDiscounted());	
	assertTrue(gscc2.isDiscounted());	
	}

}
