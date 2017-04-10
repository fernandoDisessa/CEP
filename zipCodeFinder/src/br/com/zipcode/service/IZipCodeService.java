package br.com.zipcode.service;

import br.com.zipcode.exception.InvalidZipCodeException;
import br.com.zipcode.exception.NotFoundCepException;
import br.com.zipcodemodel.model.Zipcode;

public interface IZipCodeService {

	public Zipcode findByZipcode(String zipcode) throws NotFoundCepException, IllegalArgumentException, InvalidZipCodeException;
	
	public boolean isValid(final String zipcode) throws InvalidZipCodeException, IllegalArgumentException;
}
