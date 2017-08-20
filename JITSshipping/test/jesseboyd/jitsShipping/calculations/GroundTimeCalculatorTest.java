package jesseboyd.jitsShipping.calculations;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import jesseboyd.jitsShipping.BoxParcel;
import jesseboyd.jitsShipping.DemoParcelsForTesting;
import jesseboyd.jitsShipping.Parcel;
import jesseboyd.jitsShipping.calculations.GroundTimeCalculator;

public class GroundTimeCalculatorTest {

	private GroundTimeCalculator gtc,gtc2;

	@Before
	public void setUp() throws Exception {
		
		gtc = new GroundTimeCalculator(1,2);
		gtc2= new GroundTimeCalculator(9,9);
	}

	@Test
	public void calculateGroundTime() {
		double actualTime = gtc.calculateTime();
		double expectedTime = 1.5;
		assertEquals(expectedTime, actualTime, .01);
	}
	@Test
	public void zoneCalculator() throws Exception {
		assertEquals(1,gtc.getZoneDifference());
	}
	
	@Test
	public void calcTimeinSameZone() throws Exception {
		double actual = gtc2.calculateTime();
		double expected = 1.5;
		assertEquals(expected, actual, .01);
	}
	
	@Test
	public void getTimeZones() throws Exception {
		gtc.calculateTime();
		gtc2.calculateTime();
		String from = gtc.getTimeZone1();
		String to = gtc2.getTimeZone2();
		assertEquals("ET", from);
		assertEquals("PT", to);
		
	}
	
}
