package java17demo.java8;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder = {"street", "city", "state", "zip"})
public class Address {
	private String street;
	private String city;
	private String state;
	private String zip;

	public String getStreet() {
		return street;
	}

	@XmlElement
	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	@XmlElement
	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	@XmlElement
	public void setState(String state) {
		this.state = state;
	}
	
	public String getZip() {
		return zip;
	}

	@XmlElement
	public void setZip(String zip) {
		this.zip = zip;
	}
}
