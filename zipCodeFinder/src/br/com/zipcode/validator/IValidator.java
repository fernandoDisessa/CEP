package br.com.zipcode.validator;

import br.com.zipcode.exception.InvalidZipCodeException;


public interface IValidator<T> {

	public void isValid(T object) throws InvalidZipCodeException;
}
