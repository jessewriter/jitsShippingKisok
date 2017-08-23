package jesseboyd.jitsShipping.deliveryMethods;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AirTest {

	private Air air;

	@Before
	public void setUp() throws Exception {
		air = new Air(1,9);
	}

	@Test
	public void test() {
		assertEquals(8, air.getZoneDifference(), .01);
	}

}
