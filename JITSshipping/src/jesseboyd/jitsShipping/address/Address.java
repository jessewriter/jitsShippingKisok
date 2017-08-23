package jesseboyd.jitsShipping.address;

import java.util.Map;

public interface Address {
	AddressCountry getCountry();
	AddressVector getAddressVector(); 
	Map<String, String> getAddressFields();
}
