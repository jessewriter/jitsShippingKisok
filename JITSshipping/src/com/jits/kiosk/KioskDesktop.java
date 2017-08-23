package com.jits.kiosk;

import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.management.InvalidAttributeValueException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.jits.kiosk.desktop.ConfirmationPanel;
import com.jits.kiosk.desktop.KioskRequestHandler;
import com.jits.kiosk.desktop.dialog.settings.GBHelper;
import com.jits.kiosk.desktop.dialog.settings.Gap;
import com.jits.kiosk.desktop.panels.FromAddressPanel;
import com.jits.kiosk.desktop.panels.PackagePanel;
import com.jits.kiosk.desktop.panels.ToAddressPanel;
import com.jits.transfer.IConfirmation;

public class KioskDesktop extends JFrame implements ActionListener {
	private static final long serialVersionUID = -4727468935123999950L;
	private JButton nextButton = new JButton("Submit");
	
	public static void main(String[] args){
		new KioskDesktop().showDialog();
	}

	private void showDialog() {
		GBHelper hlpr = new GBHelper();
		
		nextButton.setFont(new Font("Arial", Font.BOLD, 20));
		nextButton.addActionListener(this);
		
		setLayout(new GridBagLayout());
		
		getContentPane().add(FromAddressPanel.getPanel(),hlpr.expandW().width());
		getContentPane().add(ToAddressPanel.getPanel(),hlpr.nextRow().expandW().width());
		getContentPane().add(PackagePanel.getPanel(),hlpr.nextRow().expandW().width());
		getContentPane().add(new Gap(),hlpr.nextRow());
		getContentPane().add(nextButton,hlpr.nextCol());
		getContentPane().add(new Gap(),hlpr.nextCol().expandW());
		getContentPane().add(new Gap(),hlpr.nextRow().expandW().expandH());
		
		setTitle("JITS Kiosk");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,500);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent evt){
	    Object widget = evt.getSource(); 
	    if (widget == nextButton){
	      Map request = null;
		try {
			request = new KioskEntry().buildRequest();
		} catch (InvalidAttributeValueException e) {
			e.printStackTrace();
			return;
		}
	      // System.out.println(request);
	      if(null == request){
	    	  return;
	      }
	      // call the request handler, pass in the request map, get confirmation back
	      KioskRequestHandler handler = new KioskRequestHandler();
	      IConfirmation conf = handler.handleRequest(request);
	      
	      // display confirmation ("pending"), get user decision
	      int option = JOptionPane.showConfirmDialog(null, new ConfirmationPanel(conf), "Confirm Delivery", 
	        JOptionPane.YES_NO_OPTION);
	      
	      // send "go"/"no-go" decision to request handler, get confirmation back
	      conf = handler.handleUserDecision((option == JOptionPane.YES_OPTION) ? true : false);
	      JOptionPane.showMessageDialog(null, new ConfirmationPanel(conf), "Results", 
	        JOptionPane.INFORMATION_MESSAGE);
	    }
	  }
}
