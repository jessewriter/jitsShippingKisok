package jesseboyd.jitsShipping.calculations;

import jesseboyd.jitsShipping.deliveryMethods.DeliveryMethod;

public abstract class CostCalculator {

	private double zoneDiff;
	private double weight;
	private DeliveryMethod deliveryMethod;
	private double CONVERTOUNCESTOPOUNDS = 0.0625;
	

	// common fields zone diff, weight
	public CostCalculator(DeliveryMethod deliveryMethod, double weight) {
		this.deliveryMethod = deliveryMethod;
		this.zoneDiff = deliveryMethod.getZoneDifference();
		this.weight = weight * CONVERTOUNCESTOPOUNDS ;
	}

	abstract public double calcCost();
	//abstract double minZoneDiff();

	public double getZoneDiff() {
		return zoneDiff;
	}

	public double getWeight() {
		return weight;
	}

	public DeliveryMethod getDeliveryMethod() {
		return deliveryMethod;
	}
	
	

}
