package jesseboyd.jitsShipping;

import java.util.Map;

public interface Address {
	AddressCountry getCountry();
	AddressVector getAddressVector(); 
	Map<String, String> getAddressFields();
}
