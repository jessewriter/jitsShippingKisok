package jesseboyd.jitsShipping;

import jesseboyd.jitsShipping.deliveryMethods.DeliveryMethod;
import jesseboyd.jitsShipping.envelopes.Envelopes;

public class LetterParcel extends Parcel {
	private Envelopes packaging;

	public LetterParcel(DeliveryMethod deliveryMethod, UnitedStatesAddress origAddress, UnitedStatesAddress destAddress,
			long id, Envelopes packaging) {
		super(deliveryMethod, origAddress, destAddress, id);
		this.packaging = packaging;
	}

	public Envelopes getPackaging() {
		return packaging;
	}
	
	

}
