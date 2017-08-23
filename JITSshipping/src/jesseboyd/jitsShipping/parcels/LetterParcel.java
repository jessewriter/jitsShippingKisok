package jesseboyd.jitsShipping.parcels;

import jesseboyd.jitsShipping.deliveryMethods.DeliveryMethod;
import jesseboyd.jitsShipping.envelopes.Envelopes;

public class LetterParcel extends Parcel {
	private static final long serialVersionUID = -8544060304554781436L;
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
