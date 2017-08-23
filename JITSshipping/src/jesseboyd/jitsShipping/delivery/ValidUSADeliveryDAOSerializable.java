package jesseboyd.jitsShipping.delivery;

import java.io.Serializable;

public class ValidUSADeliveryDAOSerializable implements Serializable {
	private static final long serialVersionUID = -8909532725209495785L;
	//	private ValidUSADelivery validUSADelivery;
	private String deliveryStatus;
	private String originAddress;
	private String destinationAddress;
	private String parcelType;
	private String deliverytype;
	private String weight;
	private String time;
	private String cost;
	private String id;

	public ValidUSADeliveryDAOSerializable() {
		// DAO must have a default constructor in order to be serialized and
		// used by xml encoder
	}
	
	public ValidUSADeliveryDAOSerializable(ValidUSADelivery validUSADelivery) {
//		this.validUSADelivery = validUSADelivery;
		deliveryStatus = validUSADelivery.getDeliveryStatus().toString();
		originAddress = validUSADelivery.getFromAddress().toString();
		destinationAddress = validUSADelivery.getToAddres().toString();
		parcelType = validUSADelivery.getParcel().toString();
		deliverytype = validUSADelivery.getDeliveryMethod().toString();
		weight = String.valueOf(validUSADelivery.getWeight());
		time = String.valueOf(validUSADelivery.getTime());
		cost = String.valueOf(validUSADelivery.getCost());
		id = String.valueOf(validUSADelivery.getParcel().getId());
	}

	public String getDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

	public String getOriginAddress() {
		return originAddress;
	}

	public void setOriginAddress(String originAddress) {
		this.originAddress = originAddress;
	}

	public String getDestinationAddress() {
		return destinationAddress;
	}

	public void setDestinationAddress(String destinationAddress) {
		this.destinationAddress = destinationAddress;
	}

	public String getParcelType() {
		return parcelType;
	}

	public void setParcelType(String parcelType) {
		this.parcelType = parcelType;
	}

	public String getDeliverytype() {
		return deliverytype;
	}

	public void setDeliverytype(String deliverytype) {
		this.deliverytype = deliverytype;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	

}
