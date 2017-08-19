package jesseboyd.jitsShipping.calculations;

import jesseboyd.jitsShipping.Parcel;

public abstract class TimeCalculator {
	private int toZipDigit;
	private int fromZipDigit;
	double RATEFACTOR;
	private int zoneDifference = -1;

	TimeCalculator(Parcel parcel) {
		this.fromZipDigit = Character.getNumericValue(parcel.getOrigAddress().getZipCode().charAt(0));
		this.toZipDigit = Character.getNumericValue(parcel.getDestAddress().getZipCode().charAt(0));
	}
	abstract double calculateTime();
	
	abstract int determineZoneDifference();
	
	public int getToZipDigit() {
		return toZipDigit;
	}
	public int getFromZipDigit() {
		return fromZipDigit;
	}

	int getZoneDifference() {
		if(zoneDifference== -1) {
			calculateTime();
		}
		return zoneDifference;
	}
	public void setZoneDifference(int zoneDifference) {
		this.zoneDifference = zoneDifference;
	}

	
	
}
