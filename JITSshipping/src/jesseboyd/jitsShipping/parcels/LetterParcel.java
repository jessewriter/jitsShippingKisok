package jesseboyd.jitsShipping;

import jesseboyd.jitsShipping.deliveryMethods.DeliveryMethod;
import jesseboyd.jitsShipping.envelopes.Envelopes;

public class LetterParcel extends Parcel {
	private Envelopes packaging;

	public LetterParcel(DeliveryMethod deliveryMethod,
			long id, Envelopes packaging) {
		super(deliveryMethod, id);
		this.packaging = packaging;
	}

	public Envelopes getPackaging() {
		return packaging;
	}
	
	

}
