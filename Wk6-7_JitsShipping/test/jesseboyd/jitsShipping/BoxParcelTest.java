package jesseboyd.jitsShipping;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import jesseboyd.jitsShipping.deliveryMethods.Air;

public class BoxParcelTest {

	private BoxParcel boxParcel;

	
	private List<Parcel> parcels;
	// 2 plain, 3 weatherproof, 4 fireproof
	

	@Before
	public void setUp() throws Exception {
		parcels = DemoParcelsForTesting.getParcels();
		boxParcel = (BoxParcel) parcels.get(0);
	}

	@Test
	public void canGetDestination() {
		assertEquals("Portland", boxParcel.getDestAddress().getAddressFields().get("city"));
	}

	@Test
	public void getDeliveryType() throws Exception {
		assertTrue(boxParcel.getDeliveryMethod() instanceof Air);
	}
}
