package jesseboyd.jitsShipping.calculations;

import jesseboyd.jitsShipping.deliveryMethods.Air;

public class AirShippingCostCalculator extends CostCalculator {
//	private final double RATEFACTOR = 1.75;
	private double volume;
	
	
	public AirShippingCostCalculator(Air air, double weight, double volume ) {
		super(air, weight);
		setVolume(volume);
	}


	// Air	ZD * weight (lbs.) * volume (cu. ft.) * Cost Factor
	//Air	1.75
	@Override
	public
	double calcCost() {
		double cost = getDeliveryMethod().getZoneDifference() *getWeight() * volume * getDeliveryMethod().getCOSTRATE();
		return cost;
	}


	private void setVolume(double volume) {
		if(volume<1) {
			volume=1;
		}
		this.volume = volume;
	}


//	@Override
//	double minZoneDiff() {
//		double minZoneDiff = getZoneDiff();
//		if(minZoneDiff< getDeliveryMethod().getMINZONEDIFFERENCE()) {
//			minZoneDiff =1;
//		}
//		return minZoneDiff;
//	}
	
	

	
	
}
