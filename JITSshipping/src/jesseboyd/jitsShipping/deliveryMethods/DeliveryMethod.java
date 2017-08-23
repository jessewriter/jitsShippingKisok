package jesseboyd.jitsShipping.deliveryMethods;

import java.io.Serializable;

public abstract class DeliveryMethod implements Serializable {
	private static final long serialVersionUID = 8466708176159054976L;
	protected int toZipFirstDigit;
	protected int fromZipFirstDigit;
	protected double DISCOUNT;
	protected double TIMERATEFACTOR;
	protected double COSTRATE; 
//	private double weight;
	
	public DeliveryMethod(int toZipFirstDigit, int fromZipFirstDigit) {
		super();
		this.toZipFirstDigit = toZipFirstDigit;
		this.fromZipFirstDigit = fromZipFirstDigit;
//		this.weight = weight;
	}
	
//	abstract double getVolume();
	abstract public double getTimeRateFactor();
	abstract public double getDiscount();
	abstract public double getZoneDifference();
	public abstract double getCOSTRATE();
	public abstract double getMINZONEDIFFERENCE();

	public int getToZipFirstDigit() {
		return toZipFirstDigit;
	}

	public int getFromZipFirstDigit() {
		return fromZipFirstDigit;
	}


//	public double getWeight() {
//		return weight;
//	}
	
}
