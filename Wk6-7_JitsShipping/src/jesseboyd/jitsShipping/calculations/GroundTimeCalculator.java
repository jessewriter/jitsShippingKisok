package jesseboyd.jitsShipping.calculations;

import java.util.NavigableMap;
import java.util.TreeMap;

import jesseboyd.jitsShipping.Parcel;

public class GroundTimeCalculator extends TimeCalculator {
	private final double RATEFACTOR = 1.5;
	private NavigableMap<Integer, Integer> timeZoneMap;
	private String toZone;
	private String fromZone;

	public GroundTimeCalculator(Parcel parcel) {
		super(parcel);
		timeZoneMap = new TreeMap<Integer, Integer>();
		timeZoneMap.put(2, 4);
		timeZoneMap.put(5, 3);
		timeZoneMap.put(7, 2);
		timeZoneMap.put(9, 1);
	}

	@Override
	double calculateTime() {
		return determineZoneDifference() * RATEFACTOR;
	}

	@Override
	int determineZoneDifference() {
		System.out.println("zip digit " + getToZipDigit());
		int zoneTo = timeZoneMap.ceilingEntry(getToZipDigit()).getValue();
		toZone = setTimeZone(zoneTo);
		int zoneFrom = timeZoneMap.ceilingEntry(getFromZipDigit()).getValue();
		fromZone = setTimeZone(zoneFrom);
		int zoneDiff = Math.abs(zoneTo-zoneFrom);
		if (zoneDiff==0) {
			zoneDiff=1;
		}
		setZoneDifference(zoneDiff);
		return zoneDiff;
	}
	
	private final String[] timeZones = new String[] {"PT","MT", "CT", "ET"}; 
	String setTimeZone(int zoneNumber) {
		return timeZones[zoneNumber-1];
	}

	public String getToZone() {
		return toZone;
	}

	public String getFromZone() {
		return fromZone;
	}
	
	

}
