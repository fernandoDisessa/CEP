package br.com.addressadmin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import br.com.addressadmin.exception.NotFoundAddressException;
import br.com.addressadmin.rest.AddressRestHelper;
import br.com.zipcodebdmock.data.DataBaseMock;
import br.com.zipcodemodel.model.Address;
import br.com.zipcodemodel.model.Zipcode;

@Service
public class AddressServiceImpl implements IAddressService {

	@Autowired
	private AddressRestHelper restZipcodeService;

	@Override
	public Zipcode find(String zipcode) {

		return null;
	}

	@Override
	public ResponseEntity<Zipcode> delete(int idAddress) throws NotFoundAddressException {
	 
		ResponseEntity<Zipcode> response = null; 
		 
		
		try{		
			
			if(!DataBaseMock.delete(idAddress)){
				
				throw new NotFoundAddressException("ADDRESS NOT FOUND");
				
			}
		
		}catch(HttpClientErrorException e){
			
			throw e;
		}

		return response;

	}

	@Override
	public void update(int idAddress, Address address) throws NotFoundAddressException {
		 
		try{
		restZipcodeService.find(address.getZipcode().getZipcode());
		}catch(HttpClientErrorException e){
			throw e;
		}
		
		if(!DataBaseMock.updateAddress(idAddress,address)){
			
			throw new NotFoundAddressException("ADDRESS NOT FOUND");
			
		}
		
	}
 
}
