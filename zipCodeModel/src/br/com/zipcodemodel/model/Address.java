package br.com.zipcodemodel.model;
 

import javax.validation.constraints.NotNull;

public class Address {
	
	public Address(){}
  
	private int id;

	private Zipcode zipcode;

	@NotNull
	private String street;

	@NotNull
	private String number;

	@NotNull
	private String city;

	@NotNull
	private String state;

	private String neighbourhood;

	private String complement;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Zipcode getZipcode() {
		return zipcode;
	}

	public void setZipcode(Zipcode zipcode) {
		this.zipcode = zipcode;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getNeighbourhood() {
		return neighbourhood;
	}

	public void setNeighbourhood(String neighbourhood) {
		this.neighbourhood = neighbourhood;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	@Override
	public String toString() {
		return "Address [city=" + city + "]";
	}

	
}
