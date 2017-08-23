package jesseboyd.jitsShipping.io;

import java.util.List;
import org.junit.Before;
import org.junit.Test;

import jesseboyd.jitsShipping.DemoParcelsForTesting;
import jesseboyd.jitsShipping.address.UnitedStatesAddress;
import jesseboyd.jitsShipping.delivery.DeliveryStatus;
import jesseboyd.jitsShipping.delivery.ValidUSADelivery;
import jesseboyd.jitsShipping.delivery.ValidUSADeliveryDAOSerializable;
import jesseboyd.jitsShipping.parcels.Parcel;

public class WriteDeliveryToXMLTest {

	@SuppressWarnings("unused")
	private WriteDeliveryToXML wdtx;
	private ValidUSADelivery vud;
	private ValidUSADeliveryDAOSerializable vudds;

	@Before
	public void setUp() throws Exception {
		List<Parcel> parcels = DemoParcelsForTesting.getParcels();
		List<UnitedStatesAddress> demoStatesAddresses = DemoParcelsForTesting.getUsaAddresses();
		vud = new ValidUSADelivery(parcels.get(0), 100, 5, 7.5, demoStatesAddresses.get(0), 
				demoStatesAddresses.get(1), DeliveryStatus.accepted);
		vudds = new ValidUSADeliveryDAOSerializable(vud);
	}

	@Test
	public void test() {
		wdtx = new WriteDeliveryToXML(vudds);
	}

}
