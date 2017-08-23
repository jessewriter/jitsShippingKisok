package com.jits.kiosk.desktop;

import java.util.Map;

import com.jits.transfer.IConfirmation;

import jesseboyd.jitsShipping.calculations.MailScaleWeightCalculator;
import jesseboyd.jitsShipping.delivery.Deliver;
import jesseboyd.jitsShipping.delivery.DeliveryStatus;
import jesseboyd.jitsShipping.delivery.ValidUSADelivery;
import jesseboyd.jitsShipping.delivery.ValidUSADeliveryDAOIConfirmation;
import jesseboyd.jitsShipping.parsers.KioskSringParserV1;

public class KioskRequestHandler {


	private ValidUSADeliveryDAOIConfirmation daoConfirmation;

	/**
	 * Called from UI after user has entered all data. UI will display the
	 * returned IConfirmation data via IConfirmation.toString() and prompt user
	 * for whether to proceed or cancel the shipment.
	 */
	public IConfirmation handleRequest(Map<String, String> request) {
		
		Deliver deliver = new Deliver(new KioskSringParserV1(request), new MailScaleWeightCalculator());
		ValidUSADelivery validDelivery = deliver.getValidDelivery();
		daoConfirmation = new ValidUSADeliveryDAOIConfirmation(validDelivery);
	    return daoConfirmation;
	}

	/**
	 * Called from UI after user has chosen to proceed or cancel the shipment.
	 * UI will display the returned IConfirmation data via
	 * IConfirmation.toString(). After this call returns, shipment is now done
	 * or has been cancelled.
	 */
	public IConfirmation handleUserDecision(boolean proceedWithShipment) {
		DeliveryStatus status;
		 if(proceedWithShipment) {
			 status= DeliveryStatus.accepted;
		 }
		 else {
			 status = DeliveryStatus.canceled;
		 }
		 daoConfirmation.setStatus(status);
	    return daoConfirmation;
	}
}