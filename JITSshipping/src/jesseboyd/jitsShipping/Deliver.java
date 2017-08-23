package jesseboyd.jitsShipping;


import jesseboyd.jitsShipping.calculations.CalculationBuilder;
import jesseboyd.jitsShipping.calculations.WeightCalculator;
import jesseboyd.jitsShipping.deliveryMethods.DeliveryMethod;

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
	private double volume;
	
	// the map parser and scale are abstract and modifiable
	public Deliver(KioskStringParser kioskStringParser, WeightCalculator weightCalculator) {
		ksp1 = kioskStringParser;
		fromAddressDecoded = (UnitedStatesAddress) ksp1.parseMapForFromAddresses();
		toAddressDecoded = (UnitedStatesAddress) ksp1.parseMapForToAddresses();
		idDecoded = Long.valueOf(ksp1.kisokMapProvided.get("id"));
		deliveryMethod = ksp1.determineDeliveryMethod();
		deliveryType = ksp1.getDeliveryType();
		this.weightCalculator = weightCalculator;
		createParcel();
	}

	public String presentToCustomerForReview() throws Exception {
		if(getValidDelivery()==null) {
			throw new Exception("final delivery has not been created!");
		}
		return getValidDelivery().toString();
	}

	public String accept() {
		packageValidDelivery();
		return "Parcel has been shipped by " + parcel.getDeliveryMethodName();
	}
	
	private boolean createParcel() {
		boolean created = false;
		switch (deliveryType){
			case 'L':parcel = new LetterParcel(deliveryMethod,  idDecoded, ksp1.determineEnvelope());
			created = true;
			volume = 1.0;
			break;
			case 'B':
				BoxDimmensions boxDimensions = ksp1.determineBoxDimmensions();
				parcel = new BoxParcel(deliveryMethod, idDecoded, boxDimensions );
			created = true;
			volume = boxDimensions.getVolumeInFeet();
			break;
		}
		weightCalculator.setParcel(parcel);
		return created;
	}
	
	private boolean packageValidDelivery() {
//		int zip1 = Integer.valueOf(ksp1.parseMapForFromAddresses().getAddressFields().get("zip").substring(0, 1));
//		int zip2 = Integer.valueOf(ksp1.parseMapForToAddresses().getAddressFields().get("zip").substring(0, 1));
		CalculationBuilder cb = new CalculationBuilder(parcel, weightCalculator, volume);
		validDelivery = new ValidUSADelivery(parcel, cb.getCost(), cb.getShippingTime(), cb.getWeight(), toAddressDecoded, fromAddressDecoded);
		return true;
		
	}

	public Parcel getParcel() {
		return parcel;
	}
	
	public ValidUSADelivery getValidDelivery() {
		return validDelivery;
	}

}
