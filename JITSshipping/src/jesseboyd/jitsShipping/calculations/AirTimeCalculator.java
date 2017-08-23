package jesseboyd.jitsShipping.calculations;

import jesseboyd.jitsShipping.deliveryMethods.DeliveryMethod;

public class AirTimeCalculator extends ZipCodeTimeCalculator {
	public AirTimeCalculator(DeliveryMethod deliveryMethod) {
		super(deliveryMethod);
	}

	@Override
	public double calculateTime() {
		return getZoneDifference() * deliveryMethod.getTimeRateFactor();
	}
}
