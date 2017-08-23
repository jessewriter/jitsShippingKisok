package jesseboyd.jitsShipping.deliveryMethods;

import java.util.NavigableMap;
import java.util.TreeMap;

public class Ground extends DeliveryMethod {
	private static final long serialVersionUID = 1576971967935084198L;
	private final double DISCOUNT = 0.95;
	private double TIMERATEFACTOR = 1.5;
	private final double COSTRATE =	 1.1;
	private final double MINZONEDIFFERENCE = 0.5;
	private NavigableMap<Integer, Integer> timeZoneMap;
	String timeZone1;
	String timeZone2;
	double zoneDifference;
	
	public Ground(int toZipFirstDigit, int fromZipFirstDigit) {
		super(toZipFirstDigit, fromZipFirstDigit);
		timeZoneMap = new TreeMap<Integer, Integer>();
		timeZoneMap.put(2, 4);
		timeZoneMap.put(5, 3);
		timeZoneMap.put(7, 2);
		timeZoneMap.put(9, 1);
		zoneDifference = getZoneDifference();
	}

	//factor out ground zone difference calculator into an abstract factory
	
	@Override
	public String toString() {
		return "GroundDelivery Method Chosen";
	}


	@Override
	public
	double getZoneDifference() {
		int zoneNumber1 = timeZoneMap.ceilingEntry(toZipFirstDigit).getValue();
		timeZone1 = setTimeZone(zoneNumber1);
		int zoneNumber2 = timeZoneMap.ceilingEntry(fromZipFirstDigit).getValue();
		timeZone2 = setTimeZone(zoneNumber2);
		int zoneDiff = Math.abs(zoneNumber1-zoneNumber2);
		if(zoneDiff==0) {
			zoneDiff=1;
			TIMERATEFACTOR=1;
		}
		return zoneDiff;
	}
	
	private final String[] timeZones = new String[] {"PT","MT", "CT", "ET"}; 
	
	private String setTimeZone(int zoneNumber) {
		return timeZones[(zoneNumber-1)];
	}

	public String getTimeZone1() {
		return timeZone1;
	}

	public String getTimeZone2() {
		return timeZone2;}

	@Override
	public
	double getTimeRateFactor() {
		return TIMERATEFACTOR;
	}

	@Override
	public double getDiscount() {
		return DISCOUNT;
	}

	@Override
	public double getCOSTRATE() {
		return COSTRATE;
	}

	@Override
	public double getMINZONEDIFFERENCE() {
		return MINZONEDIFFERENCE;
	}
}
