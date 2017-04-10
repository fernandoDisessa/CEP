package br.com.zipcode.validator;

import br.com.zipcode.exception.IllegalArgumentException;
import br.com.zipcode.exception.InvalidZipCodeException;
import br.com.zipcode.util.GenericValidateUtil;


public class ZipCodeValidator implements IValidator<String> {

	private static final String INVALID_ZIPCODE="CEP inválido";
	@Override
	public void isValid(String zipcode) throws InvalidZipCodeException {
		
		notEmptyNotNull(zipcode);			
		validLenght(zipcode);
		 
	}

	private void validLenght(String zipcode) throws InvalidZipCodeException {
		if(zipcode.trim().length()!=8){
			throw  new InvalidZipCodeException(INVALID_ZIPCODE);
		}
	}

	private void notEmptyNotNull(String zipcode) throws InvalidZipCodeException {
		try {
			GenericValidateUtil.notEmptyAndNotNullStr(zipcode);
			
		} catch (IllegalArgumentException e) {
			 
			throw  new InvalidZipCodeException(e.getMessage(), e);
		}
	}
	 

}
