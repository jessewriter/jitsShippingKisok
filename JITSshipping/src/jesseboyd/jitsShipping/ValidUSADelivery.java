package jesseboyd.jitsShipping;

import java.text.NumberFormat;

public class ValidUSADelivery {
	private Parcel parcel;
	private double cost;
	private double time;
	private double weight;
	private UnitedStatesAddress toAddress, fromAddress;
	
	public ValidUSADelivery(Parcel parcel, double cost, double time, double weight, UnitedStatesAddress address1
			, UnitedStatesAddress address2) {
		super();
		this.parcel = parcel;
		this.cost = cost;
		this.time = time;
		this.weight = weight;
		if(address1.getAddressVector().equals(AddressVector.TO)) {
			toAddress = address1;
			fromAddress = address2;
		}
		else {
			toAddress = address2;
			fromAddress = address1;
		}
	}

	public Parcel getParcel() {
		return parcel;
	}

	public double getCost() {
		return cost;
	}

	public double getTime() {
		return time;
	}

	public double getWeight() {
		return weight;
	}
	
	public UnitedStatesAddress getToAddres() {
		return toAddress;
	}
	
	public UnitedStatesAddress getFromAddress() {
		return fromAddress;
	}

	@Override
	public String toString() {
		return "ValidUSADelivery [parcel=" + parcel + ", cost=" + NumberFormat.getNumberInstance(java.util.Locale.US).format(cost) + ", time=" + time + ", weight=" + weight
				+ ", toAddress=" + toAddress + ", fromAddress=" + fromAddress + "]";
	}
	
}
