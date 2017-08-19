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
import jesseboyd.jitsShipping.calculations.MailScaleWeightCalculator;

public class MailScaleWeightCalculatorTest {

	private MailScaleWeightCalculator wp2;
	private BoxParcel boxParcel;

	@Before
	public void setUp() throws Exception {
		List<Parcel> parcels = DemoParcelsForTesting.getParcels();
		boxParcel = (BoxParcel) parcels.get(0);
	}

	@Test
	public void mockScaleAndReturnAbsoluteValue() throws NoSuchMethodException, SecurityException {
	
	IMockBuilder<MailScale2> mailScale2 = EasyMock.createMockBuilder(MailScale2.class).
			addMockedMethod(MailScale2.class.getMethod("calculateWeight", Object.class ));
	
	MailScale2 mockedScale = mailScale2.createMock();
	EasyMock.expect(mockedScale.calculateWeight(boxParcel)).andReturn(6.2);
	EasyMock.replay(mockedScale);
	wp2 = new MailScaleWeightCalculator(boxParcel, mockedScale);
	assertEquals(7, wp2.weigh(), 01);
	}

}
