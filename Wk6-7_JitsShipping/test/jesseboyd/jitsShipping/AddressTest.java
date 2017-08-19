package jesseboyd.jitsShipping;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AddressTest {

	private Address address;

	@Before
	public void setUp() throws Exception {
		address = new UnitedStatesAddress("Jesse", "123 main street", "Portland", "Oregon", "97230");
	}

	@Test
	public void addressGetters() {
		UnitedStatesAddress ua = (UnitedStatesAddress) address;
		assertEquals(ua.getStreet(), "123 main street");
		// TODO test all fields?
	}

}
