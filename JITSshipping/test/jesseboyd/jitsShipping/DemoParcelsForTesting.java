package jesseboyd.jitsShipping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import jesseboyd.jitsShipping.deliveryMethods.Air;
import jesseboyd.jitsShipping.deliveryMethods.Ground;
import jesseboyd.jitsShipping.envelopes.FireProof;
import jesseboyd.jitsShipping.envelopes.Plain;
import jesseboyd.jitsShipping.envelopes.WeatherProof;

public final class DemoParcelsForTesting {
private static List<Parcel> parcels;

public  DemoParcelsForTesting() {

}
	
public static List<Parcel> getParcels(){
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
	 Address unitedStateToAddress = afTo.createAddressBasedOnCountry();
	 Address unitedStateFromAddress = afFrom.createAddressBasedOnCountry();
	
	
	BoxDimmensions boxDim = new BoxDimmensions(10,10, 10);
	BoxParcel boxParcel = new BoxParcel(new Air(), unitedStateToAddress, unitedStateFromAddress, 1l, boxDim );
	BoxParcel boxParcel2 = new BoxParcel(new Ground(), unitedStateFromAddress, unitedStateToAddress, 2l, boxDim );
	LetterParcel letterParcel = new LetterParcel(new Air(),unitedStateToAddress, unitedStateFromAddress, 3l, new Plain() );
	LetterParcel letterParcel2 = new LetterParcel(new Ground(),unitedStateToAddress, unitedStateFromAddress, 4l, new WeatherProof() );
	LetterParcel letterParcel3 = new LetterParcel(new Ground(),unitedStateToAddress, unitedStateFromAddress, 5l, new FireProof() );
	parcels = new ArrayList<>();
	parcels.add(boxParcel); 
	parcels.add(boxParcel2);
	parcels.add(letterParcel);
	parcels.add(letterParcel2);
	parcels.add(letterParcel3);
	return parcels;
	
	// test parcels
	// 0-BA, 1-BG, 2-LAP, 3-LGW, 4-LGF
}
	
	
}
