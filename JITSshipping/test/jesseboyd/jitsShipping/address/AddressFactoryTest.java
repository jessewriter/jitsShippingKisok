package jesseboyd.jitsShipping.address;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import jesseboyd.jitsShipping.address.Address;
import jesseboyd.jitsShipping.address.AddressCountry;
import jesseboyd.jitsShipping.address.AddressFactory;


public class AddressFactoryTest {

	private Map<String,String> fromAddress;
	private Map<String,String> toAddress;
	private AddressFactory afTo;
	private AddressFactory afFrom;
	private Address unitedStateToAddress;

	@Before
	public void setUp() throws Exception {
		toAddress = new HashMap<String, String>();
		toAddress.put("name", "Jesse Boyd");
		toAddress.put("street", "123 main street");
		toAddress.put("city", "Portland");
		toAddress.put("state", "Oregon");
		toAddress.put("zipCode", "97230");
				
		fromAddress = new HashMap<String, String>();
		fromAddress.put("name", "Tiffany Smith");
		fromAddress.put("street", "69 elm street");
		fromAddress.put("city", "Bloomington");
		fromAddress.put("state", "Illinois");
		fromAddress.put("zipCode", "61701");
		
		afTo = new AddressFactory(AddressCountry.USA, AddressVector.TO, toAddress );
		afFrom = new AddressFactory(AddressCountry.USA, AddressVector.FROM, fromAddress );
	}

	@Test
	public void canCreateUSAAddress() {
		Address unnitedStatesFromAddress;
			unitedStateToAddress = afTo.createAddressBasedOnCountry();
			unnitedStatesFromAddress = afFrom.createAddressBasedOnCountry();
		assertEquals(AddressCountry.USA, unitedStateToAddress.getCountry());
		assertEquals(AddressVector.TO, unitedStateToAddress.getAddressVector());
		assertEquals("Portland", unitedStateToAddress.getAddressFields().get("city"));
		assertEquals("61701", unnitedStatesFromAddress.getAddressFields().get("zipCode"));
	}
	


}
