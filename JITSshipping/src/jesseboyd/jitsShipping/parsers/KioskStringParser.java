package jesseboyd.jitsShipping.parsers;

import java.util.Map;

import jesseboyd.jitsShipping.address.Address;
import jesseboyd.jitsShipping.deliveryMethods.DeliveryMethod;
import jesseboyd.jitsShipping.dimensions.BoxDimmensions;
import jesseboyd.jitsShipping.envelopes.Envelopes;

public abstract class KioskStringParser {
	private Map<String, String> kisokMapProvided;
	
	public KioskStringParser(Map<String, String> kisokMapProvided) {
		this.kisokMapProvided = kisokMapProvided;
	}
	
	abstract public Address parseMapForToAddresses();
	abstract public Address parseMapForFromAddresses();
	public abstract DeliveryMethod determineDeliveryMethod() ;
	public abstract Envelopes determineEnvelope();
	public abstract BoxDimmensions determineBoxDimmensions();
	public abstract char getDeliveryType();

	public Map<String, String> getKisokMapProvided() {
		return kisokMapProvided;
	}
	

	
	
	
}
