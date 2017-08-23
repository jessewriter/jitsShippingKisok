package jesseboyd.jitsShipping.deliveryMethods;

public class Air extends DeliveryMethod {
	private final double DISCOUNT = 1; //no discount for air as of now
	private final double TIMERATEFACTOR = 0.25;
	private final double COSTRATE =	 1.75;
	private final double MINZONEDIFFERENCE = 1;
	public Air(int toZipFirstDigit, int fromZipFirstDigit) {
		super(toZipFirstDigit, fromZipFirstDigit);
	}

	@Override
	public String toString() {
		return "AirDelivery Method Chosen";
	}

//	@Override
//	double getVolume() {
//		if
//		return 0;
//	}

	@Override
	public
	double getTimeRateFactor() {
		return TIMERATEFACTOR;
	}

	@Override
	public
	double getZoneDifference() {
		double zoneDiff = Math.abs(getToZipFirstDigit()-getFromZipFirstDigit());
		if (zoneDiff==0) {
			zoneDiff= MINZONEDIFFERENCE;
		}
		//setZoneDifference(zoneDiff);
		return zoneDiff;
	}

	@Override
	public double getDiscount() {
		return DISCOUNT;
	}

	@Override
	public
	double getCOSTRATE() {
		return COSTRATE;
	}

	@Override
	public double getMINZONEDIFFERENCE() {
		return MINZONEDIFFERENCE;
	}

}
