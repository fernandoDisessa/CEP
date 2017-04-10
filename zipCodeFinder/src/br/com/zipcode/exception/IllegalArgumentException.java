package br.com.zipcode.exception;

public class IllegalArgumentException extends Exception {

	private static final long serialVersionUID = 1L;

	public IllegalArgumentException(String msg, Throwable cause) {

		super(msg, cause);

	}

	public IllegalArgumentException(String msg) {

		super(msg);

	}

}
