package jesseboyd.jitsShipping;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import jesseboyd.jitsShipping.deliveryMethods.Air;

public class BoxParcelTest {

	private Parcel boxParcel;

	@Before
	public void setUp() throws Exception {
		UnitedStatesAddress origAddress = new UnitedStatesAddress("123", "main street", "Portland", "Oregon", "97230");
		UnitedStatesAddress destAddress = new UnitedStatesAddress("456", "elm street", "Bloomington", "Illinois", "65060");
		BoxDimmensions boxDim = new BoxDimmensions(10,10, 10);
		boxParcel = new BoxParcel(new Air(),
				origAddress, destAddress, 2l, boxDim );
	}

	@Test
	public void canGetDestination() {
		assertEquals("Bloomington", boxParcel.getDestAddress().getCity());
	}

	@Test
	public void getDeliveryType() throws Exception {
		assertTrue(boxParcel.getDeliveryMethod() instanceof Air);
	}
}
