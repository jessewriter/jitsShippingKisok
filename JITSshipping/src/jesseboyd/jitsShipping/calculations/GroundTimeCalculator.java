package jesseboyd.jitsShipping.calculations;


import jesseboyd.jitsShipping.deliveryMethods.DeliveryMethod;


public class GroundTimeCalculator extends ZipCodeTimeCalculator {
	
	public GroundTimeCalculator(DeliveryMethod deliveryMethod) {
		super(deliveryMethod);
	}


	@Override
	double calculateTime() {
		return getZoneDifference()* TIMERATEFACTOR;
	}

}
