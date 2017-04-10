package br.com.zipcode.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import br.com.zipcode.exception.InvalidZipCodeException;
import br.com.zipcode.exception.NotFoundCepException;
import br.com.zipcode.validator.ZipCodeValidator;
import br.com.zipcodebdmock.data.DataBaseMock;
import br.com.zipcodemodel.model.Zipcode;

@Service
public class ZipcodeServiceImpl implements IZipCodeService {

	private ZipCodeValidator validator = new ZipCodeValidator();
	
 

	@Override
	public Zipcode findByZipcode(String zipcode) throws NotFoundCepException,
			IllegalArgumentException, InvalidZipCodeException {

		isValid(zipcode);

		int retry = 1;

		boolean found = false;

		Zipcode zip = DataBaseMock.find(zipcode);

		if (zip == null) {

			while (!found && retry <= 8) {

				zipcode = replaceToZero(zipcode, retry);

				zip = DataBaseMock.find(zipcode);

				if (zip != null) {
					found = true;
					break;
				}
				retry++;
			}
		}else{
			found=true;
		}

		if (!found) {
			throw new NotFoundCepException("ZipCode not found");
		}

		return zip;

		
		 
	}
 
	private String replaceToZero(String zipcode, int lastIndex) {

		String zeros = "";
		for (int i = 0; i < lastIndex; i++) {
			zeros += "0";
		}

		return StringUtils.reverse(StringUtils.reverse(zipcode).substring(
				lastIndex))
				+ zeros;

	}

	@Override
	public boolean isValid(final String zipcode)
			throws InvalidZipCodeException, IllegalArgumentException {

		validator.isValid(zipcode);

		return false;
	}

}
