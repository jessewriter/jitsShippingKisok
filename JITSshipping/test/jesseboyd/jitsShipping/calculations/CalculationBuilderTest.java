package jesseboyd.jitsShipping.calculations;

import static org.junit.Assert.*;

import java.util.List;

import org.easymock.EasyMock;
import org.easymock.IMockBuilder;
import org.junit.Before;
import org.junit.Test;

import com.thirdParty.calibration.MailScale2;

import jesseboyd.jitsShipping.DemoParcelsForTesting;
import jesseboyd.jitsShipping.parcels.BoxParcel;
import jesseboyd.jitsShipping.parcels.Parcel;

public class CalculationBuilderTest {

	private CalculationBuilder cb;
	private BoxParcel bp;
	private MailScaleWeightCalculator mswc;

	@Before
	public void setUp() throws Exception {
		// test parcels
		// 0-BA zone (1,9), 1-BG (3,3), 2-LAP (1,9), 3-LGW no discount (1,9), 4-LGF (9,9) 
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
		cb = new CalculationBuilder(bp, mswc, 0);
	}

	@Test
	public void getShippingTime() {
		double actual = cb.getShippingTime();
		double expected = 2;
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
	public void getCostWithInsurance() throws Exception {
		double actual = cb.getCost();
		double expected = 6.74;
		assertEquals(expected, actual, .1);
		
	}

}
