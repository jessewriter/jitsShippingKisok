package jesseboyd.jitsShipping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jesseboyd.jitsShipping.address.AddressCountry;
import jesseboyd.jitsShipping.address.AddressFactory;
import jesseboyd.jitsShipping.address.AddressVector;
import jesseboyd.jitsShipping.address.UnitedStatesAddress;
import jesseboyd.jitsShipping.deliveryMethods.Air;
import jesseboyd.jitsShipping.deliveryMethods.Ground;
import jesseboyd.jitsShipping.dimensions.BoxDimmensions;
import jesseboyd.jitsShipping.envelopes.FireProof;
import jesseboyd.jitsShipping.envelopes.Plain;
import jesseboyd.jitsShipping.envelopes.WeatherProof;
import jesseboyd.jitsShipping.parcels.BoxParcel;
import jesseboyd.jitsShipping.parcels.LetterParcel;
import jesseboyd.jitsShipping.parcels.Parcel;

public final class DemoParcelsForTesting {
private static List<Parcel> parcels;

public  DemoParcelsForTesting() {

}
	
public static List<Parcel> getParcels(){
	BoxDimmensions boxDim = new BoxDimmensions(10,10, 10);
	BoxParcel boxParcel = new BoxParcel(new Air(1,9), 1l, boxDim, true);// has insurance
	BoxParcel boxParcel2 = new BoxParcel(new Ground(3,3), 2l, boxDim, false ); 
	LetterParcel letterParcel = new LetterParcel(new Air(1,9), 3l, new Plain() );
	LetterParcel letterParcel2 = new LetterParcel(new Ground(1,9), 4l, new WeatherProof() );
	LetterParcel letterParcel3 = new LetterParcel(new Ground(9,9), 5l, new FireProof() );
	parcels = new ArrayList<>();
	parcels.add(boxParcel); 
	parcels.add(boxParcel2);
	parcels.add(letterParcel);
	parcels.add(letterParcel2);
	parcels.add(letterParcel3);
	return parcels;
	// test parcels
	// 0-BA zone (1,9), 1-BG (3,3), 2-LAP (1,9), 3-LGW no discount (1,9), 4-LGF (9,9) 
}
	
public static List<UnitedStatesAddress> getUsaAddresses (){
	 Map<String,String> fromAddress = new HashMap<String, String>();
	Map<String,String> toAddress = new HashMap<String, String>();
	toAddress.put("name", "Jesse Boyd");
	toAddress.put("street", "123 main street");
	toAddress.put("city", "Portland");
	toAddress.put("state", "Oregon");
	toAddress.put("zipCode", "97230");
	
	fromAddress.put("name", "Tiffany Smith");
	fromAddress.put("street", "69 elm street");
	fromAddress.put("city", "Bloomington");
	fromAddress.put("state", "Illinois");
	fromAddress.put("zipCode", "61701");
	 AddressFactory afFrom  = new AddressFactory(AddressCountry.USA, AddressVector.FROM, fromAddress );
	 AddressFactory afTo= new AddressFactory(AddressCountry.USA, AddressVector.TO, toAddress );
	 UnitedStatesAddress unitedStateToAddress = (UnitedStatesAddress) afTo.createAddressBasedOnCountry();
	 UnitedStatesAddress unitedStateFromAddress = (UnitedStatesAddress) afFrom.createAddressBasedOnCountry();
	 List<UnitedStatesAddress> returnAddresses = new ArrayList<>();
	 returnAddresses.add(unitedStateFromAddress);
	 returnAddresses.add(unitedStateToAddress);
	 return returnAddresses;
}
	
}
