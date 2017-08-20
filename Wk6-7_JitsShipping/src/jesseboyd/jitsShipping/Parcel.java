package jesseboyd.jitsShipping;

import jesseboyd.jitsShipping.deliveryMethods.DeliveryMethod;

public abstract class Parcel {

	private DeliveryMethod deliveryMethod;
	private Address origAddress;
	private Address destAddress;
	private long id;

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
	}

	public DeliveryMethod getDeliveryMethod() {
		return deliveryMethod;
	}
	
	public String getDeliveryMethodName() {
		return deliveryMethod.getClass().getSimpleName();
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
	
	@Override
	public String toString() {
		return "Parcel [deliveryMethod=" + getDeliveryMethodName() + ", origAddress=" + origAddress + ", destAddress=" + destAddress
				+ ", id=" + id + "]";
	}

}
