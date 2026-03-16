package java17demo.java8;

import java.nio.charset.Charset;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.util.Base64;

public class Application {
	public static void main(String[] args) {
		Address myAddress = new Address();
		myAddress.setStreet("123 Main Street");
		myAddress.setCity("Rochester");
		myAddress.setState("MN");
		myAddress.setZip(Integer.valueOf(55901).toString());

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
		Base64.Encoder encoder = Base64.getEncoder();
		String encodedString = encoder.encodeToString(originalString.getBytes());
		System.out.println("Original String: " + originalString);
		System.out.println("Encoded String:  " + encodedString);
		System.out.println("**************************************");
		return encodedString;
	}

	public static String decode(String encodedString) {
		String decodedString = "";
		byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
		decodedString = new String(decodedBytes, Charset.forName("UTF-8"));
		System.out.println("Encoded String:  " + encodedString);
		System.out.println("Decoded String:  " + decodedString);
		System.out.println("**************************************");
		return decodedString;
	}
}
