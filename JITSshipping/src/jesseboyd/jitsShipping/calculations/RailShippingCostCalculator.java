package jesseboyd.jitsShipping.calculations;

import jesseboyd.jitsShipping.deliveryMethods.Rail;

public class RailShippingCostCalculator extends CostCalculator {
	private double zoneDifference;

	public RailShippingCostCalculator(Rail rail) {
		super(rail);
		zoneDifference = rail.getZoneDifference();
	}

	@Override
	public double calcCost() {
		double cost;
		if(zoneDifference >0) {
			cost = 5;
		}
		else {
			cost = 2.75;
		}
		return cost;
	}

}
