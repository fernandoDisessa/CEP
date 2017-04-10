package br.com.zipcode.exception;

public class NotFoundCepException extends Exception {
	 
	private static final long serialVersionUID = 1L;

	public NotFoundCepException(String msg){
		
		super(msg);
		
	}

}
