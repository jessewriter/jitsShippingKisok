package jesseboyd.jitsShipping.calculations;

import com.thirdParty.calibration.MailScale2;

import jesseboyd.jitsShipping.Parcel;

public class MailScaleWeightCalculator implements WeightCalculator{
	private MailScale2 ms;
	private Parcel parcel;
	
	public MailScaleWeightCalculator(Parcel parcel) {
		super();
		this.parcel = parcel;
	}

	public MailScaleWeightCalculator() {
		super();
		ms = new MailScale2();
	}
	
	@Override
	public double weigh() {
	 return	Math.ceil(ms.calculateWeight(parcel));
	}

	@Override
	public boolean setParcel(Parcel parcel) {
		this.parcel = parcel;
		return true;
	}

	void setMailScaleForMocking(MailScale2 ms){
		this.ms = ms;
	}
	
}
