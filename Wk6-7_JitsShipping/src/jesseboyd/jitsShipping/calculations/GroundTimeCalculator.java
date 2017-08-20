package jesseboyd.jitsShipping.calculations;

import java.util.NavigableMap;
import java.util.TreeMap;


public class GroundTimeCalculator extends ZipCodeTimeCalculator {
	private final double RATEFACTOR = 1.5;
	private NavigableMap<Integer, Integer> timeZoneMap;
	private String timeZone1;
	private String timeZone2;

	public GroundTimeCalculator(int zip1, int zip2) {
		super(zip1, zip2);
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
		int zoneNumber1 = timeZoneMap.ceilingEntry(this.zip1).getValue();
		timeZone1 = setTimeZone(zoneNumber1);
		int zoneNumber2 = timeZoneMap.ceilingEntry(this.zip2).getValue();
		timeZone2 = setTimeZone(zoneNumber2);
		int zoneDiff = Math.abs(zoneNumber1-zoneNumber2);
		if (zoneDiff==0) {
			zoneDiff=1;
		}
		setZoneDifference(zoneDiff);
		return zoneDiff;
	}
	
	private final String[] timeZones = new String[] {"PT","MT", "CT", "ET"}; 
	String setTimeZone(int zoneNumber) {
		System.out.println("setting " + (zoneNumber-1));
		return timeZones[(zoneNumber-1)];
	}

	public String getTimeZone1() {
		return timeZone1;
	}

	public String getTimeZone2() {
		return timeZone2;
	}
	
	

}
