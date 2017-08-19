package jesseboyd.jitsShipping.calculations;


public class  AirTimeCalculator extends ZipCodeTimeCalculator {
	final double RATEFACTOR = 0.25;

	
	public AirTimeCalculator(int zip1, int zip2) {
		super(zip1, zip2);
	}

	@Override
	public double calculateTime() {
		return determineZoneDifference() * RATEFACTOR;
	}

	@Override
	int determineZoneDifference() {
		int zoneDiff = Math.abs(zip1-zip2);
		if (zoneDiff==0) {
			zoneDiff=1;
		}
		setZoneDifference(zoneDiff);
		return zoneDiff;
	}

}
