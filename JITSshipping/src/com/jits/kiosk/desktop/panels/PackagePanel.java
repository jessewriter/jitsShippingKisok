/**
 * 
 */
package com.jits.kiosk.desktop.panels;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.jits.kiosk.desktop.dialog.settings.GBHelper;
import com.jits.kiosk.desktop.dialog.settings.Gap;

/**
 * @author hyq2
 *
 */
public class PackagePanel extends JPanel implements ItemListener {
	private static final long serialVersionUID = 6539449187363347711L;
	private static final PackagePanel INSTANCE = new PackagePanel();
	private JComboBox pkgType = new JComboBox(new String[]{"Box", "Letter"});
	private JComboBox ltrType = new JComboBox(new String[]{"Plain", "Fire-proof", "Weather-proof"});
	private JTextField height = new JTextField(5);
	private JTextField width = new JTextField(5);
	private JTextField depth = new JTextField(5);
	private JCheckBox insurance = new JCheckBox("Insured");
	private JComboBox deliveryType = new JComboBox(new String[]{"Air", "Ground", "Train"});
	private JPanel dimPanel;
	
	public static PackagePanel getPanel(){
		return INSTANCE;
	}
	
	private  PackagePanel(){
		GBHelper hlpr = new GBHelper();
		setLayout(new GridBagLayout());
		dimPanel = dimensionsPanel();
	    
	    ltrType.setVisible(false);
	    pkgType.addItemListener(this);
	    
	    add(pkgType,hlpr);
	    add(new Gap(),hlpr.nextCol().expandW());
	    add(ltrType,hlpr.nextRow());
	    add(new Gap(),hlpr.nextCol().expandW());
	    add(dimPanel,hlpr.nextRow().expandW());
	    
	    add(insurance,hlpr.nextRow());
	    add(deliveryType,hlpr.nextRow());
	}
	
	private JPanel dimensionsPanel(){
		GBHelper hlpr = new GBHelper();
		JPanel panel = new JPanel();
		
		setBorder(new TitledBorder(new LineBorder(Color.BLACK),"Package Details"));
		
		panel.setLayout(new GridBagLayout());
		panel.add(new JLabel("Height"),hlpr);
		panel.add(height,hlpr.nextCol());
		panel.add(new Gap(),hlpr.nextCol().expandW());
		panel.add(new JLabel("Width"),hlpr.nextRow());
		panel.add(width,hlpr.nextCol());
		panel.add(new Gap(),hlpr.nextCol().expandW());
		panel.add(new JLabel("Depth"),hlpr.nextRow());
		panel.add(depth,hlpr.nextCol());
		panel.add(new Gap(),hlpr.nextCol().expandW());
		
		return panel;
	}
	
//	 toggles visibility of box-specific and letter-specific data entry components 
	  public void itemStateChanged(ItemEvent evt){
	    Object widget = evt.getSource();
	    if (widget == pkgType){
	      String selectedValue = (String) pkgType.getSelectedItem();
	      boolean letterMode = selectedValue.equals("Letter");
	      ltrType.setVisible(letterMode);
	      dimPanel.setVisible(!letterMode);
	      insurance.setVisible(!letterMode);
	    }
	  }

	public String getDeliveryType() {
		return (String)deliveryType.getSelectedItem();
	}

	public String getPackageDepth() {
		return depth.getText();
	}

	public String getPackageHeight() {
		return height.getText();
	}

	public boolean getInsurance() {
		return insurance.isSelected();
	}

	public String getLtrType() {
		return (String)ltrType.getSelectedItem();
	}

	public String getPkgType() {
		return (String)pkgType.getSelectedItem();
	}

	public String getPackageWidth() {
		return width.getText();
	}
	  
	  
}
