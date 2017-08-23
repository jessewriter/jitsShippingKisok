package jesseboyd.jitsShipping.io;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import jesseboyd.jitsShipping.delivery.ValidUSADelivery;
import jesseboyd.jitsShipping.delivery.ValidUSADeliveryDAOSerializable;

public class WriteDeliveryToXML {
	

	public WriteDeliveryToXML(ValidUSADeliveryDAOSerializable serializableDeliveryDAO) {
	
	try {
		XMLEncoder xe = new XMLEncoder(new BufferedOutputStream(
				new FileOutputStream(serializableDeliveryDAO.getId()+ ".xml")));
//		new FileOutputStream("test.xml")));
		xe.writeObject(serializableDeliveryDAO);
		xe.close();
	
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	
	
	}
	
	

}
