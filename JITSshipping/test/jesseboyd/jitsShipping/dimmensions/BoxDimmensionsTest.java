package jesseboyd.jitsShipping.dimmensions;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import jesseboyd.jitsShipping.dimensions.BoxDimmensions;
import jesseboyd.jitsShipping.dimensions.Dimmensions;

public class BoxDimmensionsTest {

	private Dimmensions boxDimmension;

	@Before
	public void setUp() throws Exception {
		boxDimmension = new BoxDimmensions(10,10,10);
	}

	@Test
	public void canGetDimmensions() {
		assertEquals(boxDimmension.getHeight(), 10);
	}

}
