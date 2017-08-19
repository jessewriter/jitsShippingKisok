package jesseboyd.jitsShipping;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import jesseboyd.jitsShipping.calculations.MailScaleWeightCalculator;
import jesseboyd.jitsShipping.deliveryMethods.Air;
import jesseboyd.jitsShipping.deliveryMethods.Ground;

public class DeliverTest {
	private BoxParcel boxParcel;
	private Deliver deliver, kioskDeliver;
	

	@Before
	public void setUp() throws Exception {
		UnitedStatesAddress origAddress = new UnitedStatesAddress("Jesse", "123 main street", "Portland", "Oregon", "97230");
		UnitedStatesAddress destAddress = new UnitedStatesAddress("Yara", "456 elm street", "Bloomington", "Illinois", "65060");
		BoxDimmensions boxDim = new BoxDimmensions(10,10, 10);
		boxParcel = new BoxParcel(new Air(), origAddress, destAddress, 1l, boxDim);
		deliver = new Deliver(boxParcel, new MailScaleWeightCalculator(boxParcel));
		
		Map<String, String> deliveryRequest = new HashMap<>();
		deliveryRequest.put("type", "LG");
		deliveryRequest.put("id","1");
		deliveryRequest.put("toName", "Jesse");
		deliveryRequest.put("toStreet", "1110 NE 194th Ave");
		deliveryRequest.put("toCity", "Portland");
		deliveryRequest.put("toState", "OR");
		deliveryRequest.put("toZip", "97230");
		deliveryRequest.put("toName", "Christian");
		deliveryRequest.put("toStreet", "1 E 19th Ave");
		deliveryRequest.put("toCity", "Seatle");
		deliveryRequest.put("toState", "WA");
		deliveryRequest.put("toZip", "98321");
		deliveryRequest.put("ltype", "fire-proof");
		deliveryRequest.put("fromZip", "98321");
		kioskDeliver = new Deliver(deliveryRequest, new MailScaleWeightCalculator(boxParcel));
	}

	@Test
	public void presentToCustomer() {
		System.out.println(deliver.presentToCustomerForReview());
		assertTrue(deliver.presentToCustomerForReview().contains("Parcel [deliveryMethod=Air,"
				+ " origAddress=UnitedStatesAddress [name=Jesse, street=123 main street, city=Portland, "
				+ "state=Oregon, zipCode=97230], destAddress=UnitedStatesAddress [name=Yara, street=456 elm street, city=Bloomington, state=Illinois, zipCode=65060], id=1]"));
	}
	
	@Test
	public void userAcceptsDelivery() throws Exception {
		System.out.println(deliver.accept());
		assertTrue(deliver.accept().contains("Parcel has been shipped by Air"));
	}
	
	@Test
	public void acceptDeliveryRequestFromUI() throws Exception {
		kioskDeliver.accept();
		assertTrue(kioskDeliver.getParcel().getDeliveryMethod() instanceof Ground);
		assertEquals(kioskDeliver.getParcel().getId(), 1l);
	}

}
