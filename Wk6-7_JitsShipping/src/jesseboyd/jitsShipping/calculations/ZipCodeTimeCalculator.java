package jesseboyd.jitsShipping.calculations;


public abstract class ZipCodeTimeCalculator {

	double RATEFACTOR;
	int zoneDifference = -1;
	 protected int zip1;
	protected int zip2;
	

	ZipCodeTimeCalculator(int zip1, int zip2) {
	this.zip1=zip1;
	this.zip2=zip2;
				}
	
	
	abstract double calculateTime();
	
	abstract int determineZoneDifference();
	


	int getZoneDifference() {
		if(zoneDifference== -1) {
			calculateTime();
		}
		return zoneDifference;
	}
	
	
	public void setZoneDifference(int zoneDifference) {
		this.zoneDifference = zoneDifference;
	}

	
	
}
