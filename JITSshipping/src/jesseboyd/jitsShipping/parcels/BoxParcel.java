package jesseboyd.jitsShipping.parcels;

import jesseboyd.jitsShipping.deliveryMethods.DeliveryMethod;
import jesseboyd.jitsShipping.dimensions.BoxDimmensions;

public class BoxParcel extends Parcel implements Insurable  {

	private static final long serialVersionUID = 4093892530181324869L;
	private BoxDimmensions boxDimmensions;
	private boolean isInsured;
	private double INSURANCEFACTOR = 1.10;

	public BoxParcel(DeliveryMethod eliveryMethod,
			long id, BoxDimmensions boxDimmensions, boolean isInsured) {
		super(eliveryMethod, id);
		this.boxDimmensions = boxDimmensions;
		this.isInsured = isInsured;
		updateVolume(boxDimmensions.getVolumeInFeet());
	}

	public BoxDimmensions getBoxDimmensions() {
		return boxDimmensions;
	}

	@Override
	public boolean isInsured() {
		return isInsured;
	}

	@Override
	public double getInsuranceFactor() {
		return INSURANCEFACTOR;
	}

}
