package jesseboyd.jitsShipping;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import jesseboyd.jitsShipping.deliveryMethods.Air;
import jesseboyd.jitsShipping.deliveryMethods.Ground;
import jesseboyd.jitsShipping.envelopes.FireProof;
import jesseboyd.jitsShipping.envelopes.Plain;
import jesseboyd.jitsShipping.envelopes.WeatherProof;

public class LetterParcelTest {

	private List<Parcel> parcels;
// 2 plain, 3 weatherproof, 4 fireproof
	@Before
	public void setUp() throws Exception {
		parcels = DemoParcelsForTesting.getParcels();
	}

	@Test
	public void getPackaging() {
		assertTrue(  ((LetterParcel) parcels.get(2)).getPackaging() instanceof Plain);
		assertTrue( ((LetterParcel) parcels.get(4)).getPackaging() instanceof FireProof);
		assertTrue( ((LetterParcel) parcels.get(3)).getPackaging() instanceof WeatherProof);
	}
	
	@Test
	public void getDeliveryMethod() throws Exception {
		assertTrue(((LetterParcel) parcels.get(2)).getDeliveryMethod() instanceof Air);
		assertTrue(((LetterParcel) parcels.get(3)).getDeliveryMethod() instanceof Ground);
	}

}
