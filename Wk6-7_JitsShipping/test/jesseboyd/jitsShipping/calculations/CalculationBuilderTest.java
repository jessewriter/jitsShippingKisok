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

public class CalculationBuilderTest {

	private CalculationBuilder cb;
	private BoxParcel bp;

	@Before
	public void setUp() throws Exception {
		List<Parcel> parcels = DemoParcelsForTesting.getParcels();
		bp = (BoxParcel) parcels.get(0);
		cb = new CalculationBuilder(bp, new MailScaleWeightCalculator(bp));
	}

	@Test
	public void getShippingTime() {
		double actual = cb.getShippingTime();
		double expected = .75;
		assertEquals(expected, actual, .01);
	}
	
	@Test
	public void getWeight () throws Exception {
		IMockBuilder<MailScale2> mailScale2 = EasyMock.createMockBuilder(MailScale2.class).
				addMockedMethod(MailScale2.class.getMethod("calculateWeight", Object.class ));
		
		MailScale2 mockedScale = mailScale2.createMock();
		EasyMock.expect(mockedScale.calculateWeight(bp)).andReturn(6.2).anyTimes();
		EasyMock.replay(mockedScale);
		cb = new CalculationBuilder(bp, new MailScaleWeightCalculator(bp, mockedScale));
		double weight = cb.getWeight();
		assertEquals(7, weight, 01);
	}
	
	@Test
	public void getCost() throws Exception {
		IMockBuilder<MailScale2> mailScale2 = EasyMock.createMockBuilder(MailScale2.class).
				addMockedMethod(MailScale2.class.getMethod("calculateWeight", Object.class ));
		
		MailScale2 mockedScale = mailScale2.createMock();
		EasyMock.expect(mockedScale.calculateWeight(bp)).andReturn(6.2).anyTimes();
		EasyMock.replay(mockedScale);
		cb = new CalculationBuilder(bp, new MailScaleWeightCalculator(bp, mockedScale));
		double actual = cb.getCost();
		double expected = 12250.0;
		assertEquals(expected, actual, .1);
		
	}

}
