package jesseboyd.jitsShipping.address;

import java.io.Serializable;
import java.util.Map;

public interface Address extends Serializable {
	AddressCountry getCountry();
	AddressVector getAddressVector(); 
	Map<String, String> getAddressFields();
}
