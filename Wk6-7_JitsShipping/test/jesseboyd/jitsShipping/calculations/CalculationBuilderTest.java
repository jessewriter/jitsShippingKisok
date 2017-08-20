package jesseboyd.jitsShipping.calculations;

import static org.junit.Assert.*;

import java.util.List;

import org.easymock.EasyMock;
import org.easymock.IMockBuilder;
import org.junit.Before;
import org.junit.Test;

import com.thirdParty.calibration.MailScale2;

import jesseboyd.jitsShipping.BoxParcel;
import jesseboyd.jitsShipping.DemoParcelsForTesting;
import jesseboyd.jitsShipping.Parcel;
import jesseboyd.jitsShipping.deliveryMethods.Air;

public class CalculationBuilderTest {

	private CalculationBuilder cb;
	private BoxParcel bp;
	private MailScaleWeightCalculator mswc;

	@Before
	public void setUp() throws Exception {
		List<Parcel> parcels = DemoParcelsForTesting.getParcels();
		bp = (BoxParcel) parcels.get(0);
		mswc = new MailScaleWeightCalculator();
		mswc.setParcel(bp);
		IMockBuilder<MailScale2> mailScale2 = EasyMock.createMockBuilder(MailScale2.class).
				addMockedMethod(MailScale2.class.getMethod("calculateWeight", Object.class ));
		
		MailScale2 mockedScale = mailScale2.createMock();
		EasyMock.expect(mockedScale.calculateWeight(bp)).andReturn(6.2).anyTimes();
		EasyMock.replay(mockedScale);
		mswc.setMailScaleForMocking(mockedScale);
		cb = new CalculationBuilder(bp, 2,9, mswc, 0, new Air());
	}

	@Test
	public void getShippingTime() {
		double actual = cb.getShippingTime();
		double expected = 1.75;
		assertEquals(expected, actual, .01);
	}
	
	@Test
	public void getWeight () throws Exception {
	;
	//	cb = new CalculationBuilder(bp, 2,9, new MailScaleWeightCalculator(), 3.0, new Air());
		double weight = cb.getWeight();
		assertEquals(7, weight, 01);
	}
	
	@Test
	public void getCost() throws Exception {
	
		double actual = cb.getCost();
		double expected = 12.25;
		assertEquals(expected, actual, .1);
		
	}

}
