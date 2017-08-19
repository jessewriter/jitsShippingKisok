package jesseboyd.jitsShipping;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import jesseboyd.jitsShipping.deliveryMethods.Ground;
import jesseboyd.jitsShipping.envelopes.FireProof;
import jesseboyd.jitsShipping.envelopes.Plain;
import jesseboyd.jitsShipping.envelopes.WeatherProof;

public class LetterParcelTest {

	private LetterParcel lp, lp_fire_proof, lp_weather_proof;

	@Before
	public void setUp() throws Exception {
		UnitedStatesAddress origAddress = new UnitedStatesAddress("Jesse", "123 main street", "Portland", "Oregon", "97230");
		UnitedStatesAddress destAddress = new UnitedStatesAddress("Yara", "456 elm street", "Bloomington", "Illinois", "65060");
		lp = new LetterParcel(new Ground(),origAddress, destAddress, 1, new Plain() );
		lp_fire_proof = new LetterParcel(new Ground(),origAddress, destAddress, 1, new FireProof() );
		lp_weather_proof = new LetterParcel(new Ground(),origAddress, destAddress, 2, new WeatherProof() );
	}

	@Test
	public void getPackaging() {
		assertTrue(lp.getPackaging() instanceof Plain);
		assertTrue(lp_fire_proof.getPackaging() instanceof FireProof);
		assertTrue(lp_weather_proof.getPackaging() instanceof WeatherProof);
	}

}
