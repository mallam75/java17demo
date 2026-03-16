package java17demo.java8;

import java.io.IOException;
import java.nio.charset.Charset;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Application {
	public static void main(String[] args) {
		Address myAddress = new Address();
		myAddress.setStreet("123 Main Street");
		myAddress.setCity("Rochester");
		myAddress.setState("MN");
		myAddress.setZip(new Integer(55901).toString());

		// Convert the object to XML
		writeXML(myAddress);

		// Encode/decode my street
		String encodedStreet = encode(myAddress.getStreet());
		decode(encodedStreet);
	}

	public static void writeXML(Address weather) {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Address.class);

			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(weather, System.out);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	public static String encode(String originalString) {
		BASE64Encoder encoder = new BASE64Encoder();
		String encodedString = encoder.encode(originalString.getBytes());
		System.out.println("Original String: " + originalString);
		System.out.println("Encoded String:  " + encodedString);
		System.out.println("**************************************");
		return encodedString;
	}

	public static String decode(String encodedString) {
		String decodedString = "";
		try {
			byte[] decodedBytes = new BASE64Decoder().decodeBuffer(encodedString);
			decodedString = new String(decodedBytes, Charset.forName("UTF-8"));

		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Encoded String:  " + encodedString);
		System.out.println("Decoded String:  " + decodedString);
		System.out.println("**************************************");
		return decodedString;
	}
}