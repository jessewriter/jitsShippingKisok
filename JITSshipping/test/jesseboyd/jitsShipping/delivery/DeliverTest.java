package jesseboyd.jitsShipping.delivery;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import jesseboyd.jitsShipping.calculations.MockWeightCalculatorReturns100;
import jesseboyd.jitsShipping.delivery.Deliver;
import jesseboyd.jitsShipping.deliveryMethods.Ground;
import jesseboyd.jitsShipping.parsers.KioskSringParserV1;

public class DeliverTest {
	private Deliver kioskDeliver;

	//private List<Parcel> parcels;
	// 2 plain, 3 weatherproof, 4 fireproof
	
	@Before
		public void setUp() throws Exception {
			//parcels = DemoParcelsForTesting.getParcels();
			// test parcels
			// 0-BA, 1-BG, 2-LAP, 3-LGW, 4-LGF
		//LetterParcel letterParcel = (LetterParcel) parcels.get(3);
		
		Map<String, String> deliveryRequest = new HashMap<>();
		deliveryRequest.put("type", "LG");
		deliveryRequest.put("id","1");
		deliveryRequest.put("toName", "Jesse");
		deliveryRequest.put("toStreet", "1110 NE 194th Ave");
		deliveryRequest.put("toCity", "Portland");
		deliveryRequest.put("toState", "OR");
		deliveryRequest.put("toZip", "97230");
		deliveryRequest.put("fromName", "Christian");
		deliveryRequest.put("fromStreet", "1 E 19th Ave");
		deliveryRequest.put("fromCity", "Seatle");
		deliveryRequest.put("fromState", "WA");
		deliveryRequest.put("fromZip", "98321");
		deliveryRequest.put("lType", "fire"); // can be plain, fire or weather
		kioskDeliver = new Deliver(new KioskSringParserV1(deliveryRequest) , new MockWeightCalculatorReturns100());
	}

	@Test
	public void presentToCustomer() throws Exception {
		kioskDeliver.accept();
	System.out.println(kioskDeliver.presentToCustomerForReview());
		assertTrue(kioskDeliver.presentToCustomerForReview().contains(
				 "ValidUSADelivery [parcel=LetterParcel [packaging=FireProof Evnelope], cost=6.53, time=1.0, weight=100.0, toAddress=UnitedStatesAddress [ name=Jesse \n" + 
				 " street: 1110 NE 194th Ave\n" + 
				 " city: Portland \n" + 
				 " state: OR \n" + 
				 " zipCode: 97230 ], fromAddress=UnitedStatesAddress [ name=Christian \n" + 
				 " street: 1 E 19th Ave\n" + 
				 " city: Seatle \n" + 
				 " state: WA \n" + 
				 " zipCode: 98321 ]]"));
	}
	
	@Test
	public void userAcceptsDelivery() throws Exception {
		System.out.println(kioskDeliver.accept());
		assertTrue(kioskDeliver.accept().contains("Parcel has been shipped by Ground"));
	}
	
	@Test
	public void acceptDeliveryRequestFromUI() throws Exception {
		kioskDeliver.accept();
		assertTrue(kioskDeliver.getParcel().getDeliveryMethod() instanceof Ground);
		System.out.println("id " + kioskDeliver.getParcel().getId());
		assertEquals(kioskDeliver.getParcel().getId(), 1l);
	}

}
