package jesseboyd.jitsShipping;

import jesseboyd.jitsShipping.deliveryMethods.DeliveryMethod;

public abstract class Parcel {

	private String getDeliveryMethodName;
	private DeliveryMethod deliveryMethod;
	private UnitedStatesAddress origAddress;
	private UnitedStatesAddress destAddress;
	private long id;
	private double volume =1;

	public Parcel(DeliveryMethod deliveryMethod, UnitedStatesAddress origAddress, UnitedStatesAddress destAddress,
			long id) {
				this.deliveryMethod = deliveryMethod;
				this.origAddress = origAddress;
				this.destAddress = destAddress;
				this.id = id;
				this.getDeliveryMethodName = deliveryMethod.getClass().getSimpleName();
	}

	public DeliveryMethod getDeliveryMethod() {
		return deliveryMethod;
	}
	
	public String getDeliveryMethodName() {
		return getDeliveryMethodName;
	}

	public UnitedStatesAddress getOrigAddress() {
		return origAddress;
	}

	public UnitedStatesAddress getDestAddress() {
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
