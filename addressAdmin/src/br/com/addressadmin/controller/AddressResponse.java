package br.com.addressadmin.controller;

import org.springframework.http.HttpStatus;

import br.com.zipcodemodel.model.Address;

public class AddressResponse {

	private HttpStatus status;

	private String statusMessage;

	private Address address;
	
	public AddressResponse(HttpStatus status, String statusMessage,	Address address) {
		 
		this.status = status;
		this.statusMessage = statusMessage;
		this.address = address;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

 

}
