package jesseboyd.jitsShipping.calculations;

import jesseboyd.jitsShipping.deliveryMethods.DeliveryMethod;

public abstract class ZipCodeTimeCalculator {

	double TIMERATEFACTOR;
	double zoneDifference = -1;
	protected DeliveryMethod deliveryMethod;
	 protected int zip1;
	protected int zip2;
	
	public ZipCodeTimeCalculator(DeliveryMethod deliveryMethod) {
		this.deliveryMethod = deliveryMethod;
		zip1 = deliveryMethod.getFromZipFirstDigit();
		zip2 = deliveryMethod.getToZipFirstDigit();
		TIMERATEFACTOR = deliveryMethod.getTimeRateFactor();
//		this.zoneDifference = deliveryMethod.getZoneDifference();
	}
	
	abstract double calculateTime();

	public double getZoneDifference() {
		return deliveryMethod.getZoneDifference();
	}

	
//	public void setZoneDifference(int zoneDifference) {
//		this.zoneDifference = zoneDifference;
//	}
	

	
	
}
