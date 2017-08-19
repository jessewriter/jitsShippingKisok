package jesseboyd.jitsShipping.calculations;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import jesseboyd.jitsShipping.BoxDimmensions;
import jesseboyd.jitsShipping.BoxParcel;
import jesseboyd.jitsShipping.UnitedStatesAddress;
import jesseboyd.jitsShipping.calculations.GroundTimeCalculator;
import jesseboyd.jitsShipping.deliveryMethods.Air;

public class GroundTimeCalculatorTest {

	private GroundTimeCalculator gtc,gtc2;

	@Before
	public void setUp() throws Exception {
		UnitedStatesAddress origAddress = new UnitedStatesAddress("123", "main street", "Portland", "Oregon", "97230");
		UnitedStatesAddress destAddress = new UnitedStatesAddress("456", "elm street", "Bloomington", "Illinois", "65060");
		UnitedStatesAddress destAddress2 = new UnitedStatesAddress("123", "main street", "Portland", "Oregon", "97230");
		BoxDimmensions boxDim = new BoxDimmensions(10,10, 10);
		BoxParcel boxParcel = new BoxParcel(new Air(),
				origAddress, destAddress, 2l, boxDim );
		BoxParcel boxParcel2 = new BoxParcel(new Air(),
				origAddress, destAddress2, 2l, boxDim );
		gtc = new GroundTimeCalculator(boxParcel);
		gtc2= new GroundTimeCalculator(boxParcel2);
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
		String from = gtc.getFromZone();
		String to = gtc.getToZone();
		assertEquals("PT", from);
		assertEquals("MT", to);
		
	}
	
}
