package com.jits.kiosk.desktop.panels;

import java.awt.Color;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.jits.kiosk.desktop.dialog.settings.GBHelper;

/**
 * @author hyq2
 *
 */
public class ToAddressPanel extends JPanel {
	private static final long serialVersionUID = -5529998073535591424L;
	public static final ToAddressPanel INSTANCE = new ToAddressPanel();
	private int textFieldLength = 15;
	private JLabel toLabel = new JLabel("To");
	private JTextField toName = new JTextField(textFieldLength);
	private JTextField toStreet = new JTextField(textFieldLength);
	private JTextField toCity = new JTextField(textFieldLength);
	private JTextField toState = new JTextField(textFieldLength);
	private JTextField toZip = new JTextField(textFieldLength);
	
	public static ToAddressPanel getPanel(){
		return INSTANCE;
	}
	
	private ToAddressPanel(){
		GBHelper hlpr = new GBHelper();
		setLayout(new GridBagLayout());
		
	    setBorder(new TitledBorder(new LineBorder(Color.BLACK),"To"));
	    
	    add(new JLabel("Name"),hlpr);
	    add(toName,hlpr.nextCol());
	    
	    add(new JLabel("Street"),hlpr.nextRow());
	    add(toStreet,hlpr.nextCol().expandW());
	    
	    add(new JLabel("City"),hlpr.nextRow());
	    add(toCity,hlpr.nextCol().expandW());
	    
	    add(new JLabel("State"),hlpr.nextRow());
	    add(toState,hlpr.nextCol().expandW());
	    
	    add(new JLabel("ZIP"),hlpr.nextRow());
	    add(toZip,hlpr.nextCol().expandW());
	}

	public String getToCity() {
		return toCity.getText();
	}

	public String getToLabel() {
		return toLabel.getText();
	}

	public String getToName() {
		return toName.getText();
	}

	public String getToState() {
		return toState.getText();
	}

	public String getToStreet() {
		return toStreet.getText();
	}

	public String getToZip() {
		return toZip.getText();
	}
	
}
