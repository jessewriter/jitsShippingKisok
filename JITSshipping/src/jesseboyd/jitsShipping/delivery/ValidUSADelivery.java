package jesseboyd.jitsShipping.delivery;

import java.io.Serializable;
import java.text.NumberFormat;

import jesseboyd.jitsShipping.address.AddressVector;
import jesseboyd.jitsShipping.address.UnitedStatesAddress;
import jesseboyd.jitsShipping.deliveryMethods.DeliveryMethod;
import jesseboyd.jitsShipping.parcels.Insurable;
import jesseboyd.jitsShipping.parcels.Parcel;

public class ValidUSADelivery implements Serializable{
	private static final long serialVersionUID = 2885696802175082397L;
	private Parcel parcel;
	private double cost;
	private double time;
	private double weight;
	private UnitedStatesAddress toAddress, fromAddress;
	private boolean isInsured = false;
	private DeliveryStatus deliveryStatus = DeliveryStatus.pending; // default pending
	
	public ValidUSADelivery(Parcel parcel, double cost, double time, double weight, UnitedStatesAddress address1
			, UnitedStatesAddress address2, DeliveryStatus deliveryStatus) {
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
		if(parcel instanceof Insurable) {
			isInsured = ((Insurable) parcel ).isInsured();
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

	public DeliveryMethod getDeliveryMethod() {
		return parcel.getDeliveryMethod();
	}

	public boolean isInsured() {
		return isInsured;
	}

	public void setDeliveryStatus(DeliveryStatus deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}
	
	public DeliveryStatus getDeliveryStatus() {
		return deliveryStatus;
	}
	
	
}
