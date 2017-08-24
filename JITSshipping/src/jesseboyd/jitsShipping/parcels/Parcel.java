package jesseboyd.jitsShipping.parcels;

import java.io.Serializable;

import jesseboyd.jitsShipping.deliveryMethods.DeliveryMethod;

public abstract class Parcel implements Serializable {

	private static final long serialVersionUID = -4759759515871226713L;
	private DeliveryMethod deliveryMethod;
	private long id;
	private double volume = 1; //default

	public Parcel(DeliveryMethod deliveryMethod,
			long id) {
				this.deliveryMethod = deliveryMethod;
				this.id = id;
	}

	public DeliveryMethod getDeliveryMethod() {
		return deliveryMethod;
	}
	
	public String getDeliveryMethodName() {
		return deliveryMethod.getClass().getSimpleName();
	}

	public long getId() {
		return id;
	}
	
	public boolean updateVolume(double actualVolume) {
	this.volume = actualVolume;	
	return true;
	}
	
	@Override
	public String toString() {
		return "Parcel [deliveryMethod=" + getDeliveryMethodName()+  ", id=" + id + "]";
	}
	
	public double getVolumeInFeet() {
		return volume;
	}

}
