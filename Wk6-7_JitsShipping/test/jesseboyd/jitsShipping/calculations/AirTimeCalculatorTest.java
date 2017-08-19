package jesseboyd.jitsShipping.calculations;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import jesseboyd.jitsShipping.DemoParcelsForTesting;
import jesseboyd.jitsShipping.Parcel;
import jesseboyd.jitsShipping.calculations.AirTimeCalculator;
import jesseboyd.jitsShipping.calculations.TimeCalculator;

public class AirTimeCalculatorTest {

	private TimeCalculator ac, ac2;

	@Before
	public void setUp() throws Exception {

		List<Parcel> parcels = DemoParcelsForTesting.getParcels();
		ac = new AirTimeCalculator(parcels.get(0));
		ac2 = new AirTimeCalculator(parcels.get(1));
	}

	@Test
	public void calcTimeinDiffZone() {
		double actual = ac.calculateTime();
		double expected = .75;
		assertEquals(expected, actual, .01);
	}

	@Test
	public void calcTimeinSameZone() throws Exception {
		double actual = ac2.calculateTime();
		double expected = .25;
		assertEquals(expected, actual, .01);
	}
	
	@Test
	public void getZoneDifference() throws Exception {
		assertEquals(1, ac2.getZoneDifference());
		assertEquals(3, ac.getZoneDifference());
	}

}
