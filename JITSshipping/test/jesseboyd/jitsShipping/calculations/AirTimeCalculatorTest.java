package jesseboyd.jitsShipping.calculations;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;
import jesseboyd.jitsShipping.calculations.AirTimeCalculator;

public class AirTimeCalculatorTest {

	private AirTimeCalculator ac, ac2;

	@Before
	public void setUp() throws Exception {
		ac = new AirTimeCalculator(5,5);
		ac2 = new AirTimeCalculator(4,9);
	}

	@Test
	public void calcTimeinDiffZone() {
		double actual = ac.calculateTime();
		double expected = .25;
		assertEquals(expected, actual, .01);
	}

	@Test
	public void calcTimeinSameZone() throws Exception {
		double actual = ac2.calculateTime();
		double expected = 1.25;
		assertEquals(expected, actual, .01);
	}
	
	@Test
	public void getZoneDifference() throws Exception {
		ac.calculateTime(); ac2.calculateTime();
		assertEquals(5, ac2.getZoneDifference());
		assertEquals(1, ac.getZoneDifference());
	}

}
