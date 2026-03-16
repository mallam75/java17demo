package java17demo.java8;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

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
		String encodedString = Base64.getEncoder().encodeToString(originalString.getBytes(StandardCharsets.UTF_8));
		System.out.println("Original String: " + originalString);
		System.out.println("Encoded String:  " + encodedString);
		System.out.println("**************************************");
		return encodedString;
	}

	public static String decode(String encodedString) {
		byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
		String decodedString = new String(decodedBytes, StandardCharsets.UTF_8);
		System.out.println("Encoded String:  " + encodedString);
		System.out.println("Decoded String:  " + decodedString);
		System.out.println("**************************************");
		return decodedString;
	}
}
