package jesseboyd.jitsShipping;

import java.util.HashMap;
import java.util.Map;

import jesseboyd.jitsShipping.calculations.CalculationBuilder;
import jesseboyd.jitsShipping.calculations.WeightCalculator;
import jesseboyd.jitsShipping.deliveryMethods.Air;
import jesseboyd.jitsShipping.deliveryMethods.DeliveryMethod;
import jesseboyd.jitsShipping.deliveryMethods.Ground;
import jesseboyd.jitsShipping.envelopes.Envelopes;
import jesseboyd.jitsShipping.envelopes.FireProof;
import jesseboyd.jitsShipping.envelopes.Plain;
import jesseboyd.jitsShipping.envelopes.WeatherProof;

public class Deliver {

	private Parcel parcel;
	private Map<String, String> deliveryRequest;
	private boolean mapRecieved = false;
	private ValidDelivery validDelivery;
	private WeightCalculator weightCalculator;
	
	
	public Deliver(Map<String, String> deliveryRequest, WeightCalculator weightCalculator ) {
		this.deliveryRequest = deliveryRequest;
		this.weightCalculator = weightCalculator;
		mapRecieved = true;
	}

	public Deliver(Parcel parcel, WeightCalculator weightCalculator) {
	    this.weightCalculator=weightCalculator;
		this.parcel = parcel;
		
	}

	public String presentToCustomerForReview() {
		return parcel.toString();
	}

	public String accept() {
		if(mapRecieved) {
//			createParcel();
		}
		packageValidDelivery();
		return "Parcel has been shipped by " + parcel.getDeliveryMethodName();
	}
	
//	private boolean createParcel() {
//		boolean created = false;
//		switch (deliveryRequest.get("type").charAt(0)){
//			case 'L':parcel = new LetterParcel(determineDeliveryMethod(), createToAddress(), createFromAddress(), Long.valueOf(deliveryRequest.get("id")), determineEnvelope());
//			created = true;
//			break;
//			case 'B':parcel = new BoxParcel(determineDeliveryMethod(), createToAddress(), createFromAddress(),Long.valueOf(deliveryRequest.get("id")), determineBoxDimmensions());
//			created = true;
//			break;
//		}
//		return created;
//	}
	
	private boolean packageValidDelivery() {
		CalculationBuilder cb = new CalculationBuilder(parcel, weightCalculator);
		validDelivery = new ValidDelivery(parcel, cb.getCost(), cb.getShippingTime(), cb.getWeight());
		return true;
		
	}

	public Parcel getParcel() {
		return parcel;
	}
	
	private Address createToAddress() {
		Map<String, String> toAddress = new HashMap<String, String>();
		for (String addressElement : deliveryRequest.keySet()) {
			if(addressElement.contains("to")) {
				toAddress.put(addressElement, deliveryRequest.get(addressElement));
			}
			
		}
		return new UnitedStatesAddress(AddressVector.TO,toAddress);
	}
	
//	private UnitedStatesAddress createFromAddress() {
//		return new UnitedStatesAddress(deliveryRequest.get("fromName"), deliveryRequest.get("fromStreet"), deliveryRequest.get("fromCity"), 
//				deliveryRequest.get("fromState"), deliveryRequest.get("fromZip"));
//	}
//	
//	private DeliveryMethod determineDeliveryMethod() {
//		DeliveryMethod dm;
//		if(deliveryRequest.get("type").contains("G")) {
//			dm = new Ground();
//		}
//		else {
//			dm = new Air();
//		}
//		return dm;
//	}
	
	private Envelopes determineEnvelope() {
		Envelopes e=null;
		
		switch( deliveryRequest.get("ltype")) {
		case "plain": e = new Plain();
		break;
		case "fire-proof": e = new FireProof();
		break;
		case "water-proof": e = new WeatherProof();
		}
		 return e;
	}
	
	private BoxDimmensions determineBoxDimmensions() {
		return new BoxDimmensions(
				Integer.parseInt(deliveryRequest.get("depth")),
				Integer.parseInt(deliveryRequest.get("width")),
						Integer.parseInt(deliveryRequest.get("height"))
				) ;
		}

	@SuppressWarnings("unused")
	private ValidDelivery getValidDelivery() {
		return validDelivery;
	}


	

}
