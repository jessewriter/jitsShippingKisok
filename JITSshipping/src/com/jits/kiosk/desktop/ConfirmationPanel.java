package com.jits.kiosk.desktop;

import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.jits.kiosk.desktop.dialog.settings.GBHelper;
import com.jits.transfer.IConfirmation;

public class ConfirmationPanel extends JPanel{
	private static final long serialVersionUID = -8717597962370514997L;

	public ConfirmationPanel(IConfirmation conf) {
		GBHelper hlpr = new GBHelper();
		setLayout(new GridBagLayout());
		
		add(new JLabel("Delivery Type"),hlpr);
		add(new JLabel(null!=conf?conf.getDeliveryType():""),hlpr.nextCol());
		add(new JLabel("Package Type"),hlpr.nextRow());
		add(new JLabel(null!=conf?conf.getPackageType():""),hlpr.nextCol());
		add(new JLabel("Status"),hlpr.nextRow());
		add(new JLabel(null!=conf?conf.getStatus():""),hlpr.nextCol());
		add(new JLabel("Insured"),hlpr.nextRow());
		add(new JLabel(null!=conf?new Boolean(conf.isInsured()).toString():""),hlpr.nextCol());
		add(new JLabel("From Address"),hlpr.nextRow());
		add(new JLabel(null!=conf?conf.getOrigin().toString():""),hlpr.nextCol());
		add(new JLabel("To Address"),hlpr.nextRow());
		add(new JLabel(null!=conf?conf.getDest().toString():""),hlpr.nextCol());
		add(new JLabel("Weight"),hlpr.nextRow());
		add(new JLabel(String.valueOf(null!=conf?conf.getWeight():0)),hlpr.nextCol());
		add(new JLabel("Delivery Time"),hlpr.nextRow());
		add(new JLabel(String.valueOf(null!=conf?conf.getDeliveryTime():0)),hlpr.nextCol());
		add(new JLabel("Cost"),hlpr.nextRow());
		add(new JLabel(String.valueOf(null!=conf?conf.getCost():0)),hlpr.nextCol());
	}
	
}
