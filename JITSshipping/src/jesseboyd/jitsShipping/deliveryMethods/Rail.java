package jesseboyd.jitsShipping.deliveryMethods;

public class Rail extends DeliveryMethod {
	
	

	public Rail(int toZipFirstDigit, int fromZipFirstDigit) {
		super(toZipFirstDigit, fromZipFirstDigit);
	}

	@Override
	public double getTimeRateFactor() {
		return 0;
	}

	@Override
	public double getDiscount() {
		return 0;
	}
	
	@Override
	public double getZoneDifference() {
		double answer = 1;
		if((toZipFirstDigit < 5 && fromZipFirstDigit < 5) || (toZipFirstDigit > 5 && fromZipFirstDigit > 5) ) {
			answer = 0;
		}
		return answer;
	}

	@Override
	public double getCOSTRATE() {
		return 1;
	}

	@Override
	public double getMINZONEDIFFERENCE() {
		return 0;
	}

}
