package jesseboyd.jitsShipping;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class UnitedStaesAddressTest {

	private Address address;
	private Map<String,String> toAddress;
	@Before
	public void setUp() throws Exception {
		toAddress = new HashMap<String, String>();
		toAddress.put("name", "Jesse Boyd");
		toAddress.put("street", "123 main street");
		toAddress.put("city", "Portland");
		toAddress.put("state", "Oregon");
		toAddress.put("zipCode", "97230");
		address = new UnitedStatesAddress(AddressVector.TO, toAddress);
	}

	@Test
	public void addressGetters() {
		assertEquals(address.getAddressFields().get("street"), "123 main street");
	}

}
