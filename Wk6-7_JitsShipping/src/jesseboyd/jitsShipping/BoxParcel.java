package jesseboyd.jitsShipping;

import jesseboyd.jitsShipping.deliveryMethods.DeliveryMethod;

public class BoxParcel extends Parcel {

	private BoxDimmensions boxDimmensions;

	public BoxParcel(DeliveryMethod eliveryMethod, Address address1, Address address2,
			long id, BoxDimmensions boxDimmensions) {
		super(eliveryMethod, address1, address2, id);
		this.boxDimmensions = boxDimmensions;
	}

	public BoxDimmensions getBoxDimmensions() {
		return boxDimmensions;
	}

}
