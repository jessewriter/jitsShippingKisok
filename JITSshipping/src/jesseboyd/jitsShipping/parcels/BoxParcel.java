package jesseboyd.jitsShipping.parcels;

import jesseboyd.jitsShipping.deliveryMethods.DeliveryMethod;
import jesseboyd.jitsShipping.dimensions.BoxDimmensions;

public class BoxParcel extends Parcel {

	private BoxDimmensions boxDimmensions;

	public BoxParcel(DeliveryMethod eliveryMethod,
			long id, BoxDimmensions boxDimmensions) {
		super(eliveryMethod, id);
		this.boxDimmensions = boxDimmensions;
	}

	public BoxDimmensions getBoxDimmensions() {
		return boxDimmensions;
	}

}
