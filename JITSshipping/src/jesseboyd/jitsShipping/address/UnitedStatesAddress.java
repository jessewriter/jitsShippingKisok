package jesseboyd.jitsShipping.address;

import java.util.HashMap;
import java.util.Map;

public class UnitedStatesAddress implements Address {

	private static final long serialVersionUID = -2814537640204331189L;
	private AddressVector addressVector;
	private Map<String, String> addressFields;

	public UnitedStatesAddress(AddressVector  addressVector, String name, String street, String city, String state, String zipCode) {
		addressFields = new HashMap<>();
		this.addressVector = addressVector;
		addressFields.put("name", name);
		addressFields.put("street", street);
		addressFields.put("city", city);
		addressFields.put("state", state);
		addressFields.put("zip", zipCode);
	}
	
	public UnitedStatesAddress(AddressVector  addressVector, Map<String, String> addressFieldsIn) {
		this.addressVector = addressVector;
		this.addressFields = new HashMap<>();
		addressFields.putAll(addressFieldsIn);
	}

	@Override
	public AddressCountry getCountry() {
		return AddressCountry.USA;
	}


	@Override
	public AddressVector getAddressVector() {
		return addressVector;
	}


	@Override
	public Map<String, String> getAddressFields() {
		return addressFields;
	}

	@Override
	public String toString() {
		return "UnitedStatesAddress [ name=" + addressFields.get("name") +
				" \n street: " + addressFields.get("street") +
				"\n city: " + addressFields.get("city") +
				" \n state: " + addressFields.get("state") +
				" \n zipCode: " + addressFields.get("zip") +
				" ]";
	}


}
