package br.com.addressadmin.exception;

public class NotFoundAddressException extends Exception {
	 
	private static final long serialVersionUID = 1L;

	public NotFoundAddressException(String msg){
		
		super(msg);
		
	}

}
