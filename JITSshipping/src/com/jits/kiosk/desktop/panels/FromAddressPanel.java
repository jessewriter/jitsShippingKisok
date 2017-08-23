/**
 * 
 */
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
public class FromAddressPanel extends JPanel {
	private static final long serialVersionUID = 6823664541014802206L;
	private static final FromAddressPanel INSTANCE = new FromAddressPanel();
	private int textFieldLength = 15;
	private JLabel fromLabel = new JLabel("From");
	private JTextField fromName = new JTextField(textFieldLength);
	private JTextField fromStreet = new JTextField(textFieldLength);
	private JTextField fromCity = new JTextField(textFieldLength);
	private JTextField fromState = new JTextField(textFieldLength);
	private JTextField fromZip = new JTextField(textFieldLength);
	
	public static FromAddressPanel getPanel(){
		return INSTANCE;
	}
	
	private FromAddressPanel(){
		GBHelper hlpr = new GBHelper();
		setLayout(new GridBagLayout());
		
		setBorder(new TitledBorder(new LineBorder(Color.BLACK),"From"));
	    
	    add(new JLabel("Name"),hlpr);
	    add(fromName,hlpr.nextCol().expandW());
	    
	    add(new JLabel("Street"),hlpr.nextRow());
	    add(fromStreet,hlpr.nextCol().expandW());
	    
	    add(new JLabel("City"),hlpr.nextRow());
	    add(fromCity,hlpr.nextCol().expandW());
	    
	    add(new JLabel("State"),hlpr.nextRow());
	    add(fromState,hlpr.nextCol().expandW());
	    add(new JLabel("ZIP"),hlpr.nextRow());
	    add(fromZip,hlpr.nextCol().expandW());
	}

	public String getFromCity() {
		return fromCity.getText();
	}

	public String getFromLabel() {
		return fromLabel.getText();
	}

	public String getFromName() {
		return fromName.getText();
	}
	public String getFromState() {
		return fromState.getText();
	}

	public String getFromStreet() {
		return fromStreet.getText();
	}

	public String getFromZip() {
		return fromZip.getText();
	}
	
	
}
