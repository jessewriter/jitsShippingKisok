package jesseboyd.jitsShipping.calculations;

import jesseboyd.jitsShipping.Parcel;
import jesseboyd.jitsShipping.deliveryMethods.Air;
import jesseboyd.jitsShipping.deliveryMethods.DeliveryMethod;
import jesseboyd.jitsShipping.deliveryMethods.Ground;

public class CalculationBuilder {
	private DeliveryMethod deliveryMethod;
	private double shippingTime;
	private WeightCalculator weightCalculator;
	private int zoneDiff;
	private double volume;
	private double weight;
	private String toZone, fromZone;
	private int zone1;
	private int zone2;
	

	public CalculationBuilder(Parcel parcel, int zip1, int zip2, WeightCalculator weightCalculator, double volume, DeliveryMethod deliveryMethod) {
		//this.parcel = parcel;
		zone1 = zip1;
		zone2 = zip2;
		this.weightCalculator = weightCalculator;
		this.volume = volume;
		this.deliveryMethod = deliveryMethod;
		generateShippingTime();
		getWeight();
		getCost();
	}

	public double getShippingTime() {
		return shippingTime;
	}
	
	private double generateShippingTime() {
		double answer;
		if(deliveryMethod instanceof Air) {
			AirTimeCalculator atc = new AirTimeCalculator(zone1, zone2);
			answer= atc.calculateTime();
	}
		else if(deliveryMethod instanceof Ground) {

			GroundTimeCalculator gtc = new GroundTimeCalculator(zone1, zone2);
			toZone = gtc.getTimeZone1();
			fromZone = gtc.getTimeZone2();
			answer= gtc.calculateTime();
		}
		else {
			throw new IllegalArgumentException("Delivery method must be Air or Ground");
		}
		shippingTime = answer;
		return answer;
	}
	
	public int getFirstNumberFromString(String x) {
		return Integer.valueOf(x.charAt(0));
	}

	public double getWeight() {
		weight = weightCalculator.weigh();
		return weight ;
	}

	public double getCost() {
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
		return "CalculationBuilder [ deliveryMethod=" + deliveryMethod + ", shippingTime="
				+ shippingTime + ", weightCalculator=" + weightCalculator + ", zoneDiff=" + zoneDiff + ", volume="
				+ volume + ", weight=" + weight + ", toZone=" + toZone + ", fromZone=" + fromZone + "]";
	}

}
