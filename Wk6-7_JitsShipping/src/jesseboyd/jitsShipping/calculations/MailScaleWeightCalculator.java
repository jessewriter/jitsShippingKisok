package jesseboyd.jitsShipping.calculations;

import com.thirdParty.calibration.MailScale2;

import jesseboyd.jitsShipping.Parcel;

public class MailScaleWeightCalculator implements WeightCalculator{
	private Parcel parcel;
	private MailScale2 ms;
	
	public MailScaleWeightCalculator(Parcel parcel) {
		super();
		this.parcel = parcel;
		ms = new MailScale2();
	}
	
	public MailScaleWeightCalculator(Parcel parcel, MailScale2 mailscale) {
		super();
		this.parcel = parcel;
		this.ms=mailscale;
	}

	public double weigh() {
	 return	Math.ceil(ms.calculateWeight(parcel));
	}

}
