package jesseboyd.jitsShipping;

@SuppressWarnings("unused")
public class ValidDelivery {
	private Parcel parcel;
	private double cost;
	private double time;
	private double weight;
	
	public ValidDelivery(Parcel parcel, double cost, double time, double weight) {
		super();
		this.parcel = parcel;
		this.cost = cost;
		this.time = time;
		this.weight = weight;
	}

	private Parcel getParcel() {
		return parcel;
	}

	private double getCost() {
		return cost;
	}

	private double getTime() {
		return time;
	}

	private double getWeight() {
		return weight;
	}
	
	
	
	
}
