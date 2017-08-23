package jesseboyd.jitsShipping.deliveryMethods;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RailTest {

	private Rail rail, rail2;

	@Before
	public void setUp() throws Exception {
		rail = new Rail(1,1);
		rail2 = new Rail(1,9);
	}

	@Test
	public void railSameZone() {
		assertEquals(0, rail.getZoneDifference(),.01);
	}
	
	@Test
	public void railDifferentZone() throws Exception {
		assertEquals(1, rail2.getZoneDifference(), .01);
	}

}
