package jesseboyd.jitsShipping;

import java.util.HashMap;
import java.util.Map;

import jesseboyd.jitsShipping.deliveryMethods.Air;
import jesseboyd.jitsShipping.deliveryMethods.DeliveryMethod;
import jesseboyd.jitsShipping.deliveryMethods.Ground;
import jesseboyd.jitsShipping.envelopes.Envelopes;
import jesseboyd.jitsShipping.envelopes.FireProof;
import jesseboyd.jitsShipping.envelopes.Plain;
import jesseboyd.jitsShipping.envelopes.WeatherProof;

public class KioskSringParserV1 extends KioskStringParser {
	
	public KioskSringParserV1(Map<String, String> kisokMapProvided) {
		super(kisokMapProvided);
	}

	@Override
	public UnitedStatesAddress parseMapForToAddresses() {
		Map<String, String> toAddressModified = new HashMap<String, String>();
		for (String addressElement : kisokMapProvided.keySet()) {
			if(addressElement.contains("to")) {
				toAddressModified.put(addressElement.substring(2).toLowerCase(), kisokMapProvided.get(addressElement));
			}
			
		}
		return new UnitedStatesAddress(AddressVector.TO,toAddressModified);
	}
	
	@Override
	public UnitedStatesAddress parseMapForFromAddresses() {
		Map<String, String> fromAddressModified = new HashMap<String, String>();
		for (String addressElement : kisokMapProvided.keySet()) {
			if(addressElement.contains("from")) {
				fromAddressModified.put(addressElement.substring(4).toLowerCase(), kisokMapProvided.get(addressElement));
			}
			
		}
		return new UnitedStatesAddress(AddressVector.FROM,fromAddressModified);
	}

	@Override
	public DeliveryMethod determineDeliveryMethod() {
		DeliveryMethod dm;
		if(kisokMapProvided.get("type").contains("G")) {
			dm = new Ground();
		}
		else {
			dm = new Air();
		}
		return dm;
	}
	@Override
	public Envelopes determineEnvelope() {
		Envelopes e=null;
		
		switch( kisokMapProvided.get("ltype")) {
		case "plain": e = new Plain();
		break;
		case "fire-proof": e = new FireProof();
		break;
		case "water-proof": e = new WeatherProof();
		}
		 return e;
	}
	@Override
	public BoxDimmensions determineBoxDimmensions() {
		return new BoxDimmensions(
				Integer.parseInt(kisokMapProvided.get("depth")),
				Integer.parseInt(kisokMapProvided.get("width")),
						Integer.parseInt(kisokMapProvided.get("height"))
				) ;
		}

	@Override
	public char getDeliveryType() {
		return kisokMapProvided.get("type").charAt(0);
	}

}
