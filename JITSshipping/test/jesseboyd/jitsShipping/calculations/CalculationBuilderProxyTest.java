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

public class CalculationBuilderProxyTest {
	
	CalculationBuilderProxy cp;

	@Before
	public void setUp() throws Exception {
		// test parcels
				// 0-BA zone (1,9), 1-BG (3,3), 2-LAP (1,9), 3-LGW no discount (1,9), 4-LGF (9,9) 
				List<Parcel> parcels = DemoParcelsForTesting.getParcels();
				BoxParcel bp = (BoxParcel) parcels.get(0);
				MailScaleWeightCalculator mswc = new MailScaleWeightCalculator(bp);
				// mock call to mailScale2
				IMockBuilder<MailScale2> mailScale2 = EasyMock.createMockBuilder(MailScale2.class).
						addMockedMethod(MailScale2.class.getMethod("calculateWeight", Object.class ));
				MailScale2 mockedScale = mailScale2.createMock();
				EasyMock.expect(mockedScale.calculateWeight(bp)).andReturn(6.2).anyTimes();
				EasyMock.replay(mockedScale);
				// end mock setup
				mswc.setMailScaleForMocking(mockedScale);
				CalculationBuilder cb = new CalculationBuilder(bp, mswc);
		cp = new CalculationBuilderProxy(cb);
	}

	@Test
	public void test() {
		assertEquals(6.74, cp.getCost(), .01);
	}

}
