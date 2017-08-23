package jesseboyd.jitsShipping.delivery;


import com.jits.transfer.IConfirmation;

import jesseboyd.jitsShipping.address.Address;
import jesseboyd.jitsShipping.address.UnitedStatesAddress;

public class ValidUSADeliveryDAOIConfirmation implements IConfirmation {
	//	private ValidUSADelivery validUSADelivery;
	private UnitedStatesAddress originAddress;
	private UnitedStatesAddress destinationAddress;
	private String parcelType;
	private String deliverytype;
	private double weight;
	private double time;
	private double cost;
	private boolean isInsured;
	private String status;

	
	public ValidUSADeliveryDAOIConfirmation(ValidUSADelivery validUSADelivery) {
		originAddress = validUSADelivery.getFromAddress();
		destinationAddress = validUSADelivery.getToAddres();
		parcelType = validUSADelivery.getParcel().toString();
		deliverytype = validUSADelivery.getDeliveryMethod().toString();
		weight = validUSADelivery.getWeight();
		time = validUSADelivery.getTime();
		cost = validUSADelivery.getCost();
		isInsured = validUSADelivery.isInsured();
		status = validUSADelivery.getDeliveryStatus().toString();
	}

	@Override
	public Address getOrigin() {
		return originAddress;
	}

	@Override
	public Address getDest() {
		return destinationAddress;
	}

	@Override
	public String getPackageType() {
		return parcelType;
	}

	@Override
	public String getDeliveryType() {
		return deliverytype;
	}

	@Override
	public double getWeight() {
		return weight;
	}

	@Override
	public boolean isInsured() {
		return isInsured;
	}

	@Override
	public double getDeliveryTime() {
		return time;
	}

	@Override
	public double getCost() {
		return cost;
	}

	@Override
	public String getStatus() {
		return status;
	}

	public void setStatus(DeliveryStatus status2) {
		this.status = status2.toString();
		
	}
	
	
	

}
