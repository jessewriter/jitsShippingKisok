package jesseboyd.jitsShipping.calculations;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Observable;
import java.util.logging.Logger;

import jesseboyd.jitsShipping.auditor.CostAuditor;
import jesseboyd.jitsShipping.deliveryMethods.Air;
import jesseboyd.jitsShipping.deliveryMethods.DeliveryMethod;
import jesseboyd.jitsShipping.deliveryMethods.Ground;
import jesseboyd.jitsShipping.deliveryMethods.Rail;
import jesseboyd.jitsShipping.parcels.Insurable;
import jesseboyd.jitsShipping.parcels.Parcel;

public class CalculationBuilder extends Observable implements JitsCalculator{
	private DeliveryMethod deliveryMethod;
	private double shippingTime;
	private WeightCalculator weightCalculator;
	private int zoneDiff;
	private double volume;
	private double weight;
	private String toZone, fromZone;
	private Parcel parcel;
	Logger log = Logger.getLogger("CalculationsBuilder");

	
	// need a factory that takes with/without weightcalculator
	public CalculationBuilder(Parcel parcel, WeightCalculator weightCalculator) {
		this.parcel = parcel;
		this.weightCalculator = weightCalculator;
		this.volume = parcel.getVolumeInFeet();
		this.deliveryMethod = parcel.getDeliveryMethod();
		shippingTime = generateShippingTime();
		getWeight();
		getCost();
	}

	public double getShippingTime() {
		return shippingTime;
	}
	
	private double generateShippingTime() {
		double answer;
		if(deliveryMethod instanceof Air) {
			AirTimeCalculator atc = new AirTimeCalculator(deliveryMethod);
			answer= atc.calculateTime();
	}
		else if(deliveryMethod instanceof Rail) {
			RailTimeCalculator rtc = new RailTimeCalculator(deliveryMethod);
			answer= rtc.calculateTime();
	}
		
		else if(deliveryMethod instanceof Ground) {

			GroundTimeCalculator gtc = new GroundTimeCalculator(deliveryMethod);
			answer= gtc.calculateTime();
		}
		else {
			throw new IllegalArgumentException("Delivery method must be Air, Rail or Ground");
		}
		return answer;
	}
	
	public int getFirstNumberFromString(String x) {
		return Integer.valueOf(x.charAt(0));
	}

	public double getWeight() {
		weight = weightCalculator.weigh();
		return weight ;
	}

	@Override
	public double getCost() {
		double answer;
		if(deliveryMethod instanceof Air) {
			AirShippingCostCalculator asc = new AirShippingCostCalculator((Air) deliveryMethod, weight, volume);
			answer = asc.calcCost();
		}
		else if(deliveryMethod instanceof Rail) {
			RailShippingCostCalculator rsc = new RailShippingCostCalculator((Rail) deliveryMethod);
			answer = rsc.calcCost();
		}
		else if(deliveryMethod instanceof Ground) {
			GroundShippingCostCalculator gscc = 
					new GroundShippingCostCalculator((Ground) deliveryMethod, weight);
			answer = gscc.calcCost();
		}
		else {
			throw new IllegalArgumentException("Delivery method must be Air or Ground");
		}
		// notify observers of pre-insurance cost
		this.addObserver(new CostAuditor());
		this.setChanged();
		Date date = new Date();
		String modifiedDate= new SimpleDateFormat("yyyy-MM-dd").format(date);
		this.notifyObservers(parcel.getId() + " " 
		+ NumberFormat.getCurrencyInstance().format(answer) + " " + modifiedDate + "\n");
		////////////////////////////////////////////////////////
		if(parcel instanceof Insurable && ((Insurable) parcel).isInsured()) {
	log.info("cost before insurance " + answer);
	answer = answer * ((Insurable) parcel).getInsuranceFactor();
	log.info("cost after insurance " + answer);
		}
		return Math.round(answer*100.0)/100.0;  
		// make sure you use the round that returns an int not long
	}
	
	@Override
	public String toString() {
		return "CalculationBuilder [ deliveryMethod=" + deliveryMethod + ", shippingTime="
				+ shippingTime + ", weightCalculator=" + weightCalculator + ", zoneDiff=" + zoneDiff + ", volume="
				+ volume + ", weight=" + weight + ", toZone=" + toZone + ", fromZone=" + fromZone + "]";
	}

}
