package jesseboyd.jitsShipping;

public class UnitedStatesAddress implements Address {

	private String name;
	private String street;
	private String city;
	private String state;
	private String zipCode;

	public UnitedStatesAddress(String name, String street, String city, String state, String zipCode) {
		this.name = name;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
	}


	public String getName() {
		return name;
	}


	public String getStreet() {
		return street;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getZipCode() {
		return zipCode;
	}


	@Override
	public String toString() {
		return "UnitedStatesAddress [name=" + name + ", street=" + street + ", city=" + city + ", state=" + state
				+ ", zipCode=" + zipCode + "]";
	}


}
