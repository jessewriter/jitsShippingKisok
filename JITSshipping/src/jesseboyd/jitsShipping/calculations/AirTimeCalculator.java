package jesseboyd.jitsShipping.calculations;

import jesseboyd.jitsShipping.deliveryMethods.DeliveryMethod;

public class  AirTimeCalculator extends ZipCodeTimeCalculator {
	public AirTimeCalculator(DeliveryMethod deliveryMethod) {
		super(deliveryMethod);
		// TODO Auto-generated constructor stub
	}

	final double RATEFACTOR = 0.25;

	
//	public AirTimeCalculator(int zip1, int zip2) {
//		super(zip1, zip2);
//	}

	@Override
	public double calculateTime() {
		return getZoneDifference() * RATEFACTOR;
	}

	@Override
	double getZoneDifference() {
		int zoneDiff = Math.abs(zip1-zip2);
		if (zoneDiff==0) {
			zoneDiff=1;
		}
		setZoneDifference(zoneDiff);
		return zoneDiff;
	}

}
