package jesseboyd.jitsShipping.calculations;

import jesseboyd.jitsShipping.Parcel;

public class MockWeightCalculatorReturns100 implements WeightCalculator {

	@Override
	public double weigh() {
		// TODO Auto-generated method stub
		return 100;
	}

	@Override
	public boolean setParcel(Parcel parcel) {
		// TODO Auto-generated method stub
		return false;
	}

}
