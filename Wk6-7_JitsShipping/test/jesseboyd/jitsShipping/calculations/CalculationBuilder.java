package jesseboyd.jitsShipping.calculations;

import jesseboyd.jitsShipping.Parcel;
import jesseboyd.jitsShipping.deliveryMethods.Air;
import jesseboyd.jitsShipping.deliveryMethods.DeliveryMethod;
import jesseboyd.jitsShipping.deliveryMethods.Ground;

public class CalculationBuilder {
	private Parcel parcel;
	private DeliveryMethod deliveryMethod;
	private double shippingTime;
	private WeightCalculator weightCalculator;
	private int zoneDiff;
	private double volume;
	private double weight;
	private String toZone, fromZone;
	

	public CalculationBuilder(Parcel parcel, WeightCalculator weightCalculator) {
		this.parcel = parcel;
		this.weightCalculator = weightCalculator;
		volume = parcel.getVolume();
		deliveryMethod = parcel.getDeliveryMethod();
		shippingTime();
		getWeight();
		getCost();
	}

	public double getShippingTime() {
		return shippingTime;
	}
	
	private double shippingTime() {
		double answer;
		if(deliveryMethod instanceof Air) {
			AirTimeCalculator atc = new AirTimeCalculator(parcel);
			answer= atc.calculateTime();
	}
		else if(deliveryMethod instanceof Ground) {
			GroundTimeCalculator gtc = new GroundTimeCalculator(parcel);
			toZone = gtc.getToZone();
			fromZone = gtc.getFromZone();
			answer= gtc.calculateTime();
		}
		else {
			throw new IllegalArgumentException("Delivery method must be Air or Ground");
		}
		shippingTime = answer;
		return answer;
	}

	public double getWeight() {
		weight = weightCalculator.weigh();
		return weight ;
	}

	public double getCost() {
		System.out.println(this.toString());
		double answer;
		if(deliveryMethod instanceof Air) {
			AirShippingCostCalculator asc = new AirShippingCostCalculator(zoneDiff, weight, volume);
			answer = asc.calcCost();
		}
		else if(deliveryMethod instanceof Ground) {
			GroundShippingCostCalculator gscc = 
					new GroundShippingCostCalculator(zoneDiff, weight, toZone, fromZone);
			answer = gscc.calcCost();
		}
		else {
			throw new IllegalArgumentException("Delivery method must be Air or Ground");
		}
		return answer;
	}

	@Override
	public String toString() {
		return "CalculationBuilder [parcel=" + parcel + ", deliveryMethod=" + deliveryMethod + ", shippingTime="
				+ shippingTime + ", weightCalculator=" + weightCalculator + ", zoneDiff=" + zoneDiff + ", volume="
				+ volume + ", weight=" + weight + ", toZone=" + toZone + ", fromZone=" + fromZone + "]";
	}
	
	

}
