package jesseboyd.jitsShipping.calculations;


public abstract class CostCalculator {

	private int zoneDiff;
	private double weight;

	// common fields zone diff, weight
	public CostCalculator(int zoneDiff, double weight) {
		this.zoneDiff = zoneDiff;
		this.weight = weight;
	}

	abstract public double calcCost();
	abstract double minZoneDiff();

	public int getZoneDiff() {
		return zoneDiff;
	}

	public double getWeight() {
		return weight;
	}

}
