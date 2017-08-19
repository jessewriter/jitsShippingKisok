package jesseboyd.jitsShipping;

import java.util.ArrayList;
import java.util.List;

import jesseboyd.jitsShipping.deliveryMethods.Air;

public final class DemoParcelsForTesting {
private static List<Parcel> parcels;

public  DemoParcelsForTesting() {

}
	
public static List<Parcel> getParcels(){
	UnitedStatesAddress origAddress = new UnitedStatesAddress("123", "main street", "Portland", "Oregon", "97230");
	UnitedStatesAddress destAddress = new UnitedStatesAddress("456", "elm street", "Bloomington", "Illinois", "65060");
	UnitedStatesAddress destAddress2 = new UnitedStatesAddress("123", "main street", "Portland", "Oregon", "97230");
	BoxDimmensions boxDim = new BoxDimmensions(10,10, 10);
	BoxParcel boxParcel = new BoxParcel(new Air(),
			origAddress, destAddress, 2l, boxDim );
	BoxParcel boxParcel2 = new BoxParcel(new Air(),
			origAddress, destAddress2, 2l, boxDim );
	parcels = new ArrayList<>();
	parcels.add(boxParcel);
	parcels.add(boxParcel2);
	return parcels;
}
	
	
}
