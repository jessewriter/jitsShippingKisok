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
import jesseboyd.jitsShipping.parcels.LetterParcel;
import jesseboyd.jitsShipping.parcels.Parcel;

public class CalculationBuilderTest {

	private CalculationBuilder cb, cb2, cb3;
	private BoxParcel bp, bp2;
	private LetterParcel letterAir;
	private MailScaleWeightCalculator mswc, mswc2, mswc3;

	@Before
	public void setUp() throws Exception {
		// test parcels
		// 0-BA zone (1,9), 1-BG (3,3), 2-LAP (1,9), 3-LGW no discount (1,9), 4-LGF (9,9) 
		List<Parcel> parcels = DemoParcelsForTesting.getParcels();
		bp = (BoxParcel) parcels.get(0); // has insurance
		bp2 = (BoxParcel) parcels.get(1); // no insurance
		letterAir = (LetterParcel) parcels.get(2);
		mswc = new MailScaleWeightCalculator(bp);
		mswc2 = new MailScaleWeightCalculator(letterAir);
		// mock call to mailScale2
		IMockBuilder<MailScale2> mailScale2 = EasyMock.createMockBuilder(MailScale2.class).
				addMockedMethod(MailScale2.class.getMethod("calculateWeight", Object.class ));
		MailScale2 mockedScale = mailScale2.createMock();
		EasyMock.expect(mockedScale.calculateWeight(bp)).andReturn(6.2).anyTimes();
		EasyMock.expect(mockedScale.calculateWeight(letterAir)).andReturn(11.9).anyTimes();
		EasyMock.replay(mockedScale);
		// end mock setup
		mswc.setMailScaleForMocking(mockedScale);
		mswc2.setMailScaleForMocking(mockedScale);
		cb = new CalculationBuilder(bp, mswc);
		cb3 = new CalculationBuilder(bp2, mswc); // no insurance cost
		cb2 = new CalculationBuilder(letterAir, mswc2);
	}

	@Test
	public void getShippingTime() {
		double actual = cb.getShippingTime();
		double expected = 2;
		assertEquals(expected, actual, .01);
	}
	
	@Test
	public void getWeight () throws Exception {
		double weight = cb.getWeight();
		assertEquals(7, weight, 01);
	}
	
	@Test
	public void getGroundCostWithInsurance() throws Exception {
		double actual = cb.getCost();
		double expected = 6.74;
		assertEquals(expected, actual, .1);
	}
	
	@Test
	public void getGroundCostWithOutInsurance() throws Exception {
		double actual = cb3.getCost();
		double expected = 0.46;
		assertEquals(expected, actual, .1);
	}

	@Test
	public void getAirCost() throws Exception {
		double actual = cb2.getCost();
		double expected = 10.5;
		assertEquals( expected, actual, .01);
	}
	
	@Test
	public void letterVolumeIsDefault1() throws Exception {
		assertEquals(1, letterAir.getVolumeInFeet(), .01);
	}
	
	@Test
	public void boxVolume() throws Exception {
		assertEquals((10*10*10*0.000578704), bp.getVolumeInFeet(), .01);
	}
}
