package jesseboyd.jitsShipping.deliveryMethods;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GroundTest {

	Ground ground;
	
	@Before
	public void setup() {
		ground = new Ground(1,9);
	}
	
	@Test
	public void test() {
		
		
		assertEquals("ET", ground.getTimeZone1());
	}

}
