package br.com.zipcode.exception;

public class InvalidZipCodeException extends Exception {

	private static final long serialVersionUID = 1958340146411652003L;

	public InvalidZipCodeException(String msg, Throwable cause) {

		super(msg, cause);

	}

	public InvalidZipCodeException(String msg) {

		super(msg);

	}

}
