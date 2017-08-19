package jesseboyd.jitsShipping.calculations;

public class GroundShippingCostCalculator extends CostCalculator {
	private final double COSTFACTOR = 1.1;
	private double DISCOUNT = .95;
	private String toZone;
	private String fromZone;

	public GroundShippingCostCalculator(int zoneDiff, double weight, String toZone, String fromZone) {
		super(zoneDiff, weight);
		this.toZone = toZone;
		this.fromZone = fromZone;
	}

	//zd * weight * costFactor * discount
	// min volume =1.0
	// no discount that includes only on zone of PT
	@Override
	public
	double calcCost() {
		isDiscounted();
	
		double cost = minZoneDiff() * getWeight() * COSTFACTOR * DISCOUNT;
		return cost;
	}

	public boolean isDiscounted() {
		boolean appliedDiscount=true;
		if(toZone != fromZone && ((toZone+fromZone).contains("PT"))) {
			DISCOUNT=1.0;
			appliedDiscount=false;
		}
		return appliedDiscount;
	}

	@Override
	double minZoneDiff() {
		double minZoneDiff = getZoneDiff();
		if(minZoneDiff<1) {
			minZoneDiff =.5;
		}
		return minZoneDiff;
	}
}
