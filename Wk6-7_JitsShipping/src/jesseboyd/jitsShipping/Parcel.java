package jesseboyd.jitsShipping;

import jesseboyd.jitsShipping.deliveryMethods.DeliveryMethod;

public abstract class Parcel {

	private String getDeliveryMethodName;
	private DeliveryMethod deliveryMethod;
	private Address origAddress;
	private Address destAddress;
	private long id;
	private double volume =1;

	public Parcel(DeliveryMethod deliveryMethod, Address address1, Address address2,
			long id) {
				this.deliveryMethod = deliveryMethod;
				if(address1.getAddressVector().equals(AddressVector.FROM)) {
				this.origAddress = address1;
				this.destAddress = address2;
				}
				else {
					this.origAddress = address2;
					this.destAddress = address1;
				}
				this.id = id;
				this.getDeliveryMethodName = deliveryMethod.getClass().getSimpleName();
	}

	public DeliveryMethod getDeliveryMethod() {
		return deliveryMethod;
	}
	
	public String getDeliveryMethodName() {
		return getDeliveryMethodName;
	}

	public Address getOrigAddress() {
		return origAddress;
	}

	public Address getDestAddress() {
		return destAddress;
	}

	public long getId() {
		return id;
	}
	
	public double getVolume() {
		return volume;
	}
	
	public void setVolume(double volume) {
		this.volume = volume;
	}

	@Override
	public String toString() {
		return "Parcel [deliveryMethod=" + getDeliveryMethodName + ", origAddress=" + origAddress + ", destAddress=" + destAddress
				+ ", id=" + id + "]";
	}

}
