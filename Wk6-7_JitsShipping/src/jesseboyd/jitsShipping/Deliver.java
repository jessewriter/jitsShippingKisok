package jesseboyd.jitsShipping;

import jesseboyd.jitsShipping.calculations.CalculationBuilder;
import jesseboyd.jitsShipping.calculations.WeightCalculator;
import jesseboyd.jitsShipping.deliveryMethods.DeliveryMethod;

public class Deliver {

	private Parcel parcel;
	private ValidDelivery validDelivery;
	private WeightCalculator weightCalculator;
	private Address toAddressDecoded;
	private Address fromAddressDecoded;
	private long idDecoded;
	private DeliveryMethod deliveryMethod;
	private KioskStringParser ksp1;
	private char deliveryType;
	private double volume;
	
	// the map parser and scale are abstract and modifiable
	public Deliver(KioskStringParser kioskStringParser, WeightCalculator weightCalculator) {
		ksp1 = kioskStringParser;
		fromAddressDecoded = ksp1.parseMapForFromAddresses();
		toAddressDecoded = ksp1.parseMapForToAddresses();
		idDecoded = Long.valueOf(ksp1.kisokMapProvided.get("id"));
		deliveryMethod = ksp1.determineDeliveryMethod();
		deliveryType = ksp1.getDeliveryType();
		this.weightCalculator = weightCalculator;
	}

	public String presentToCustomerForReview() {
		return parcel.toString();
	}

	public String accept() {
			createParcel();
		packageValidDelivery();
		return "Parcel has been shipped by " + parcel.getDeliveryMethodName();
	}
	
	private boolean createParcel() {
		boolean created = false;
		switch (deliveryType){
			case 'L':parcel = new LetterParcel(deliveryMethod, toAddressDecoded, fromAddressDecoded, idDecoded, ksp1.determineEnvelope());
			created = true;
			volume = 1.0;
			break;
			case 'B':
				BoxDimmensions boxDimensions = ksp1.determineBoxDimmensions();
				parcel = new BoxParcel(deliveryMethod, toAddressDecoded, fromAddressDecoded, idDecoded, boxDimensions );
			created = true;
			volume = boxDimensions.getVolumeInFeet();
			break;
		}
		weightCalculator.setParcel(parcel);
		return created;
	}
	
	private boolean packageValidDelivery() {
		System.out.println(ksp1.parseMapForFromAddresses().getAddressFields().get("zipCode"));
		int zip1 = Integer.valueOf(ksp1.parseMapForFromAddresses().getAddressFields().get("zipCode").substring(0, 1));
		int zip2 = Integer.valueOf(ksp1.parseMapForToAddresses().getAddressFields().get("zipCode").substring(0, 1));
		CalculationBuilder cb = new CalculationBuilder(parcel, zip1, zip2, weightCalculator, volume, deliveryMethod);
		validDelivery = new ValidDelivery(parcel, cb.getCost(), cb.getShippingTime(), cb.getWeight());
		return true;
		
	}

	public Parcel getParcel() {
		return parcel;
	}


	@SuppressWarnings("unused")
	private ValidDelivery getValidDelivery() {
		return validDelivery;
	}


	

}
