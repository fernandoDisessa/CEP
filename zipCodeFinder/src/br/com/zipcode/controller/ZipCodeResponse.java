package br.com.zipcode.controller;

import org.springframework.http.HttpStatus;

import br.com.zipcodemodel.model.Zipcode;

public class ZipCodeResponse {

	private HttpStatus status;

	private String zipCodeRequest;

	private String statusMessage;

	private Zipcode zipcodeResponse; 

	public ZipCodeResponse(HttpStatus status, String zipCodeRequest,String statusMessage, Zipcode zipcodeResponse) { 
		this.status = status;
		this.zipCodeRequest = zipCodeRequest;
		this.statusMessage = statusMessage;
		this.zipcodeResponse = zipcodeResponse;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getZipCodeRequest() {
		return zipCodeRequest;
	}

	public void setZipCodeRequest(String zipCodeRequest) {
		this.zipCodeRequest = zipCodeRequest;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	public Zipcode getZipcodeResponse() {
		return zipcodeResponse;
	}

	public void setZipcodeResponse(Zipcode zipcodeResponse) {
		this.zipcodeResponse = zipcodeResponse;
	}

}
