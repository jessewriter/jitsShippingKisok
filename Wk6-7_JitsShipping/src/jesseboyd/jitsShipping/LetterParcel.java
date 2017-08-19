package jesseboyd.jitsShipping;

import jesseboyd.jitsShipping.deliveryMethods.DeliveryMethod;
import jesseboyd.jitsShipping.envelopes.Envelopes;

public class LetterParcel extends Parcel {
	private Envelopes packaging;

	public LetterParcel(DeliveryMethod deliveryMethod, Address address1, Address address2,
			long id, Envelopes packaging) {
		super(deliveryMethod, address1, address2, id);
		this.packaging = packaging;
	}

	public Envelopes getPackaging() {
		return packaging;
	}
	
	

}
