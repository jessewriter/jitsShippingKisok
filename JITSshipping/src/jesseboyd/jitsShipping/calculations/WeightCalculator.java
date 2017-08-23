package jesseboyd.jitsShipping.calculations;

import jesseboyd.jitsShipping.parcels.Parcel;

public interface WeightCalculator {
	
	public double weigh() ;
	public boolean setParcel(Parcel parcel);

}
