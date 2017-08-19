package jesseboyd.jitsShipping;

import jesseboyd.jitsShipping.deliveryMethods.DeliveryMethod;

public class BoxParcel extends Parcel {

	private BoxDimmensions boxDimmensions;

	public BoxParcel(DeliveryMethod eliveryMethod, UnitedStatesAddress origAddress, UnitedStatesAddress destAddress,
			long id, BoxDimmensions boxDimmensions) {
		super(eliveryMethod, origAddress, destAddress, id);
		this.boxDimmensions = boxDimmensions;
		setVolume(boxDimmensions.getVolumeInInches());
	}

	public BoxDimmensions getBoxDimmensions() {
		return boxDimmensions;
	}

}
