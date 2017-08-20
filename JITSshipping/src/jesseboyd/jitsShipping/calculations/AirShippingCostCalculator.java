package jesseboyd.jitsShipping.calculations;


public class AirShippingCostCalculator extends CostCalculator {
	private final double RATEFACTOR = 1.75;
	private double volume;
	
	
	public AirShippingCostCalculator(int zoneDiff, double weight, double volume ) {
		super(zoneDiff, weight);
		setVolume(volume);
	}


	// Air	ZD * weight (lbs.) * volume (cu. ft.) * Cost Factor
	//Air	1.75
	@Override
	public
	double calcCost() {
		double cost = minZoneDiff() *getWeight() * volume * RATEFACTOR;
		return cost;
	}


	private void setVolume(double volume) {
		if(volume<1) {
			volume=1;
		}
		this.volume = volume;
	}


	@Override
	double minZoneDiff() {
		int minZoneDiff = getZoneDiff();
		if(minZoneDiff<1) {
			minZoneDiff =1;
		}
		return minZoneDiff;
	}
	
	

	
	
}
