package jesseboyd.jitsShipping.address;

import java.util.Map;

public class AddressFactory {

	private AddressCountry country;
	private AddressVector addressVector;
	private Map<String, String> addressFields;

	public AddressFactory(AddressCountry country, AddressVector addressVector, Map<String, String> addressFields) {
		this.country = country;
		this.addressVector = addressVector;
		this.addressFields = addressFields;
	}

	public Address createAddressBasedOnCountry() {
		Address address;
		if (country == AddressCountry.USA) {
			address = createUnitedStatesAddress();
		}
		else {
		address = null; // will never be called since locked by list of enums
		// no need to throw exception either
		}
		return address;
	}

	 private UnitedStatesAddress createUnitedStatesAddress() {
		return new UnitedStatesAddress(addressVector, addressFields);
	}

}
