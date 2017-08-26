package com.jits.kiosk;

import java.util.HashMap;
import java.util.Map;

import javax.management.InvalidAttributeValueException;
import javax.swing.JOptionPane;

import com.jits.kiosk.desktop.panels.FromAddressPanel;
import com.jits.kiosk.desktop.panels.PackagePanel;
import com.jits.kiosk.desktop.panels.ToAddressPanel;

public class KioskEntry {

	public KioskEntry() {
		// this.setUpUI();
	}

	@SuppressWarnings("unchecked")
	public Map<String, String> buildRequest() throws InvalidAttributeValueException {
		// create delivery request from UI
		Map<String, String> request = new HashMap();

		enterFromData(request);
		enterToData(request);
		// store package-delivery type (LG|LA|BG|BA) //rail?
		String packageCode = PackagePanel.getPanel().getPkgType().substring(0,1);
		String deliveryCode = PackagePanel.getPanel().getDeliveryType().substring(0, 1);
		request.put("type", packageCode + deliveryCode);

		// generate and store an ID
		request.put("id", String.valueOf(System.currentTimeMillis()));

		// store box data if applicable
		if (packageCode.equals("B")) {
			enterBoxData(request);
		}
		// store letter data if applicable
		else if (packageCode.equals("L")) {
			enterLetterData(request);
		}
		//
		
		return request;
	}

	private void enterToData(Map<String, String> request) throws InvalidAttributeValueException {
		String name = ToAddressPanel.getPanel().getToName();
		String street = ToAddressPanel.getPanel().getToStreet();
		String city = ToAddressPanel.getPanel().getToCity();
		String state = ToAddressPanel.getPanel().getToState();
		String zip = ToAddressPanel.getPanel().getToZip();
		
		if ((null == name || name.length() == 0)
				|| (null == street || street.length() == 0)
				|| (null == city || city.length() == 0)
				|| (null == state || state.length() == 0)
				|| (null == zip || zip.length() == 0)) {
			JOptionPane.showMessageDialog(null,
					"Please enter postal data for receiver.", "Error",
					JOptionPane.ERROR_MESSAGE);
			throw new InvalidAttributeValueException("Missing Destination Address Data");
		}
		if(zip.length()!=5 || !zip.matches("\\d+")){
			JOptionPane.showMessageDialog(null,
					"Please enter a valid postal code.", "Error",
					JOptionPane.ERROR_MESSAGE);
			throw new InvalidAttributeValueException("The zip code is improperly formatted");
		}
		request.put("toName", name);
		request.put("toStreet", street);
		request.put("toCity", city);
		request.put("toState", state);
		request.put("toZip", zip);
	}

	private void enterFromData(Map<String, String> request) throws InvalidAttributeValueException {
		String name = FromAddressPanel.getPanel().getFromName();
		String street = FromAddressPanel.getPanel().getFromStreet();
		String city = FromAddressPanel.getPanel().getFromCity();
		String state = FromAddressPanel.getPanel().getFromState();
		String zip = FromAddressPanel.getPanel().getFromZip();
		
		if ((null == name || name.length() == 0)
				|| (null == street || street.length() == 0)
				|| (null == city || city.length() == 0)
				|| (null == state || state.length() == 0)
				|| (null == zip || zip.length() == 0)) {
			JOptionPane.showMessageDialog(null,
					"Please enter all postal data for sender.", "Error",
					JOptionPane.ERROR_MESSAGE);
			throw new InvalidAttributeValueException("Missing Sender address data");
		}
		if(zip.length()!=5 || !zip.matches("\\d+")){
			JOptionPane.showMessageDialog(null,
					"Please enter a valid postal code.", "Error",
					JOptionPane.ERROR_MESSAGE);
			throw new InvalidAttributeValueException("The zip code is improperly formatted");
		}
		request.put("fromName", name);
		request.put("fromStreet", street);
		request.put("fromCity", city);
		request.put("fromState", state);
		request.put("fromZip", zip);
	}

	private void enterLetterData(Map<String, String> request) {
		String letterTypeUI = PackagePanel.getPanel().getLtrType();
		String letterType = "plain";
		if (letterTypeUI.equals("Fire-proof")) {
			letterType = "fire";
		} else if (letterTypeUI.equals("Weather-proof")) {
			letterType = "weather";
		}
		request.put("lType", letterType);
	}

	private void enterBoxData(Map<String, String> request) throws InvalidAttributeValueException {
		String height = PackagePanel.getPanel().getPackageHeight();
		String width = PackagePanel.getPanel().getPackageWidth();
		String depth = PackagePanel.getPanel().getPackageDepth();
		if ((null == height || height.length() == 0)
				|| (null == width || width.length() == 0)
				|| (null == depth || depth.length() == 0)) {
			JOptionPane.showMessageDialog(null,
					"Please enter all three dimensions.", "Error",
					JOptionPane.ERROR_MESSAGE);
			throw new InvalidAttributeValueException("Missing dimensions for box parsel");
		}
		if(!height.matches("\\d+")||!width.matches("\\d+")||!depth.matches("\\d+")){
			JOptionPane.showMessageDialog(null,
					"Please enter valid numeric dimensions.", "Error",
					JOptionPane.ERROR_MESSAGE);
			throw new InvalidAttributeValueException("Invalid box dimension.");
		}
		request.put("height", height);
		request.put("width", width);
		request.put("depth", depth);
		request.put("insured", String.valueOf(PackagePanel.getPanel()
				.getInsurance()));
	}
}