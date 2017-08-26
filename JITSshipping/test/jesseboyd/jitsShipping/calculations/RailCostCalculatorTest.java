package jesseboyd.jitsShipping.calculations;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import jesseboyd.jitsShipping.deliveryMethods.Rail;

public class RailCostCalculatorTest {
	
	

	private RailShippingCostCalculator rscc, rscc2;

	@Before
	public void setUp() throws Exception {
		
		rscc = new RailShippingCostCalculator(new Rail(1,9));
		rscc2 = new RailShippingCostCalculator(new Rail(1,1));
	}

	@Test
	public void differentZones5() {
		assertEquals(5, rscc.calcCost(),.01);
	}
	
	@Test
	public void sameZone275() throws Exception {
		assertEquals(2.75, rscc2.calcCost(),.01);
	}

}
