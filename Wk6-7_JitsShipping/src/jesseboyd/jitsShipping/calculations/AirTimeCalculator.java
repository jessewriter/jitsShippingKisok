package jesseboyd.jitsShipping.calculations;

import jesseboyd.jitsShipping.Parcel;

public class  AirTimeCalculator extends TimeCalculator {
	final double RATEFACTOR = 0.25;

	
	public AirTimeCalculator(Parcel parcel) {
		super(parcel);
	}

	@Override
	public double calculateTime() {
		return determineZoneDifference() * RATEFACTOR;
	}

	@Override
	int determineZoneDifference() {
		int zoneDiff = Math.abs(getToZipDigit()-getFromZipDigit());
		if (zoneDiff==0) {
			zoneDiff=1;
		}
		setZoneDifference(zoneDiff);
		return zoneDiff;
	}

}
