package jesseboyd.jitsShipping.calculations;

import jesseboyd.jitsShipping.deliveryMethods.DeliveryMethod;

public class RailTimeCalculator extends ZipCodeTimeCalculator{

	public RailTimeCalculator(DeliveryMethod deliveryMethod) {
		super(deliveryMethod);
	}

	@Override
	double calculateTime() {
		double time=5.0;
		if(deliveryMethod.getZoneDifference()==1) {
			time = 10.0;
		}
		return time;
	}

//	@Override
//	public double getZoneDifference() {
//		return deliveryMethod.getZoneDifference();
//	}

}
