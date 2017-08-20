package jesseboyd.jitsShipping;

import java.util.Map;

import jesseboyd.jitsShipping.deliveryMethods.DeliveryMethod;
import jesseboyd.jitsShipping.envelopes.Envelopes;

public abstract class KioskStringParser {
	Map<String, String> kisokMapProvided;
	
	public KioskStringParser(Map<String, String> kisokMapProvided) {
		this.kisokMapProvided = kisokMapProvided;
	}
	
	abstract public Address parseMapForToAddresses();
	abstract public Address parseMapForFromAddresses();
	public abstract DeliveryMethod determineDeliveryMethod() ;
	public abstract Envelopes determineEnvelope();
	public abstract BoxDimmensions determineBoxDimmensions();
	public abstract char getDeliveryType();
	

	
	
	
}
