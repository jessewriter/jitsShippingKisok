package jesseboyd.jitsShipping.calculations;

import jesseboyd.jitsShipping.deliveryMethods.Ground;

public class GroundShippingCostCalculator extends CostCalculator {
//	private final double COSTFACTOR = 1.1;
	private double DISCOUNT = getDeliveryMethod().getDiscount();
	private String toZone;
	private String fromZone;

	public GroundShippingCostCalculator(Ground ground, double weight) {
		super(ground, weight);
		this.toZone = ground.getTimeZone1();
		this.fromZone = ground.getTimeZone2();
	}

	//zd * weight * costFactor * discount
	// min volume =1.0
	// no discount that includes only on zone of PT
	@Override
	public
	double calcCost() {
		isDiscounted();
		double cost = getZoneDiff() * getWeight() * getDeliveryMethod().getCOSTRATE() * DISCOUNT;
		return cost;
	}

	// BRING IN DISCOUNT FROM GROUND
	public boolean isDiscounted() {
		boolean appliedDiscount=true;
		if(toZone != fromZone && ((toZone+fromZone).contains("PT"))) {
			DISCOUNT=1; // removes discount
			appliedDiscount=false;
		}
		return appliedDiscount;
	}

//	@Override
//	double minZoneDiff() {
//		double minZoneDiff = getZoneDiff();
//		if(minZoneDiff<1) {
//			minZoneDiff = getDeliveryMethod().getMINZONEDIFFERENCE();
//		}
//		return minZoneDiff;
//	}
}
