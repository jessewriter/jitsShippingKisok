package jesseboyd.jitsShipping.parsers;

import java.util.HashMap;
import java.util.Map;

import jesseboyd.jitsShipping.address.AddressVector;
import jesseboyd.jitsShipping.address.UnitedStatesAddress;
import jesseboyd.jitsShipping.deliveryMethods.Air;
import jesseboyd.jitsShipping.deliveryMethods.DeliveryMethod;
import jesseboyd.jitsShipping.deliveryMethods.Ground;
import jesseboyd.jitsShipping.deliveryMethods.Rail;
import jesseboyd.jitsShipping.dimensions.BoxDimmensions;
import jesseboyd.jitsShipping.envelopes.Envelopes;
import jesseboyd.jitsShipping.envelopes.FireProof;
import jesseboyd.jitsShipping.envelopes.Plain;
import jesseboyd.jitsShipping.envelopes.WeatherProof;

public class KioskSringParserV1 extends KioskStringParser {
	private UnitedStatesAddress usAddressTo;
	private UnitedStatesAddress usAddressFrom;
	private int zip1, zip2;
	
	public KioskSringParserV1(Map<String, String> kisokMapProvided) {
		super(kisokMapProvided);
		usAddressTo = parseMapForToAddresses();
		usAddressFrom = parseMapForFromAddresses();
		zip1 = Integer.valueOf(usAddressTo.getAddressFields().get("zip").substring(0, 1));
		zip2 = Integer.valueOf(usAddressFrom.getAddressFields().get("zip").substring(0, 1));
	}
//TODO USE COUNTRY TO CALL ADDRESS FACTORY AND RETURN THE CORRECT ADDRESS?
	
	
	
	@Override
	public UnitedStatesAddress parseMapForToAddresses() {
		Map<String, String> toAddressModified = new HashMap<String, String>();
		for (String addressElement : getKisokMapProvided().keySet()) {
			if(addressElement.contains("to")) {
				toAddressModified.put(addressElement.substring(2).toLowerCase(), getKisokMapProvided().get(addressElement));
			}
			
		}
		
		return new UnitedStatesAddress(AddressVector.TO,toAddressModified);
	}
	
	@Override
	public UnitedStatesAddress parseMapForFromAddresses() {
		Map<String, String> fromAddressModified = new HashMap<String, String>();
		for (String addressElement : getKisokMapProvided().keySet()) {
			if(addressElement.contains("from")) {
				fromAddressModified.put(addressElement.substring(4).toLowerCase(), getKisokMapProvided().get(addressElement));
			}
			
		}
		return new UnitedStatesAddress(AddressVector.FROM,fromAddressModified);
	}

	// need first digits of zip and weight
	// don't have weight, just return a string to be handled later?
	@Override
	public DeliveryMethod determineDeliveryMethod() {
		String deliveryMethod = getKisokMapProvided().get("type");
		DeliveryMethod dm;
		if(deliveryMethod.contains("G")) {
			dm = new Ground(zip1, zip2);
		}
		if(deliveryMethod.contains("R") || deliveryMethod.contains("T")) {
			dm = new Rail(zip1, zip2);
		}
		else {
			dm = new Air(zip1, zip2);
		}
		return dm;
	}
	@Override
	public Envelopes determineEnvelope() {
		Envelopes e=null;
		
		switch( getKisokMapProvided().get("lType")) {
		case "plain": e = new Plain();
		break;
		case "fire": e = new FireProof();
		break;
		case "weather": e = new WeatherProof();
		}
		 return e;
	}
	@Override
	public BoxDimmensions determineBoxDimmensions() {
		return new BoxDimmensions(
				Integer.parseInt(getKisokMapProvided().get("depth")),
				Integer.parseInt(getKisokMapProvided().get("width")),
						Integer.parseInt(getKisokMapProvided().get("height"))
				) ;
		}

	@Override
	public char getDeliveryType() {
		return getKisokMapProvided().get("type").charAt(0);
	}

}
