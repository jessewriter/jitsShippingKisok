package jesseboyd.jitsShipping.calculations;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import jesseboyd.jitsShipping.calculations.GroundTimeCalculator;
import jesseboyd.jitsShipping.deliveryMethods.Ground;

public class GroundTimeCalculatorTest {

	private GroundTimeCalculator gtc, gtc2;

	@Before
	public void setUp() throws Exception {

		gtc = new GroundTimeCalculator(new Ground(1, 9));
		gtc2 = new GroundTimeCalculator(new Ground(5, 5));
	}

	@Test
	public void calculateGroundTime() {
		double actualTime = gtc.calculateTime();
		double expectedTime = 4.5;
		assertEquals(expectedTime, actualTime, .01);
	}

	@Test
	public void zoneCalculator() throws Exception {
		assertEquals(3, gtc.getZoneDifference(), .01);
	}

	@Test
	public void calcTimeinSameZone() throws Exception {
		double actual = gtc2.calculateTime();
		double expected = 1.0;
		assertEquals(expected, actual, .01);
	}

}
