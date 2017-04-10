package br.com.zipcodemodel.model;

 

public class Zipcode {

	public Zipcode() {
	}
	
	public Zipcode(String zipcode) { 
		this.zipcode = zipcode;  
	}


	private int id;

	private String zipcode;

 

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	 

}
