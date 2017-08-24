package jesseboyd.jitsShipping.delivery;

import jesseboyd.jitsShipping.address.UnitedStatesAddress;
import jesseboyd.jitsShipping.calculations.CalculationBuilder;
import jesseboyd.jitsShipping.calculations.WeightCalculator;
import jesseboyd.jitsShipping.deliveryMethods.DeliveryMethod;
import jesseboyd.jitsShipping.dimensions.BoxDimmensions;
import jesseboyd.jitsShipping.parcels.BoxParcel;
import jesseboyd.jitsShipping.parcels.LetterParcel;
import jesseboyd.jitsShipping.parcels.Parcel;
import jesseboyd.jitsShipping.parsers.KioskStringParser;

public class Deliver {

	private Parcel parcel;
	private ValidUSADelivery validDelivery;
	private WeightCalculator weightCalculator;
	private UnitedStatesAddress toAddressDecoded;
	private UnitedStatesAddress fromAddressDecoded;
	private long idDecoded;
	private DeliveryMethod deliveryMethod;
	private KioskStringParser ksp1;
	private char deliveryType;

	// the map parser and scale are abstract and modifiable
	public Deliver(KioskStringParser kioskStringParser, WeightCalculator weightCalculator) {
		ksp1 = kioskStringParser;
		fromAddressDecoded = (UnitedStatesAddress) ksp1.parseMapForFromAddresses();
		toAddressDecoded = (UnitedStatesAddress) ksp1.parseMapForToAddresses();
		idDecoded = Long.valueOf(ksp1.getKisokMapProvided().get("id"));
		deliveryMethod = ksp1.determineDeliveryMethod();
		deliveryType = ksp1.getDeliveryType();
		this.weightCalculator = weightCalculator;
		createParcel();
		packageValidDelivery(DeliveryStatus.pending);
	}

	public String presentToCustomerForReview() throws Exception {
		if (getValidDelivery() == null) {
			throw new Exception("final delivery has not been created!");
		}
		return getValidDelivery().toString();
	}

	public String accept() {
		validDelivery.setDeliveryStatus(DeliveryStatus.accepted);
		;
		return "Parcel has been shipped by " + parcel.getDeliveryMethodName();
	}

	private boolean createParcel() {
		boolean created = false;
		switch (deliveryType) {
		case 'L':
			parcel = new LetterParcel(deliveryMethod, idDecoded, ksp1.determineEnvelope());
			created = true;
			break;
		case 'B':
			BoxDimmensions boxDimensions = ksp1.determineBoxDimmensions();
			parcel = new BoxParcel(deliveryMethod, idDecoded, boxDimensions,
					Boolean.valueOf(ksp1.getKisokMapProvided().get("insured")));
			created = true;
			break;
		}
		weightCalculator.setParcel(parcel);
		return created;
	}

	private boolean packageValidDelivery(DeliveryStatus deliveryStatus) {
		CalculationBuilder cb = new CalculationBuilder(parcel, weightCalculator);
		validDelivery = new ValidUSADelivery(parcel, cb.getCost(), cb.getShippingTime(), cb.getWeight(),
				toAddressDecoded, fromAddressDecoded, deliveryStatus);
		return true;
	}

	public Parcel getParcel() {
		return parcel;
	}

	public ValidUSADelivery getValidDelivery() {
		return validDelivery;
	}

}
