package jesseboyd.jitsShipping.calculations;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import jesseboyd.jitsShipping.deliveryMethods.Rail;

public class RailTimeCalculatorTest {

	private RailTimeCalculator rtc;

	@Before
	public void setUp() throws Exception {
		rtc = new RailTimeCalculator(new Rail(1,9));
	}

	@Test
	public void railGetZoneDifference() {
		assertEquals(1, rtc.getZoneDifference(), .01);
	}

}
