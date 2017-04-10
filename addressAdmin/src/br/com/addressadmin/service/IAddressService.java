package br.com.addressadmin.service;

import org.springframework.http.ResponseEntity;

import br.com.addressadmin.exception.NotFoundAddressException;
import br.com.zipcodemodel.model.Address;
import br.com.zipcodemodel.model.Zipcode;

public interface IAddressService {

	public ResponseEntity<Zipcode> delete(final int idAddress) throws NotFoundAddressException;
	
	public Zipcode find(String zipcode);
	
	public void update(int idAddress, Address address)  throws NotFoundAddressException;
}
