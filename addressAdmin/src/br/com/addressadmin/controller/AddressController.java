package br.com.addressadmin.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import br.com.addressadmin.exception.NotFoundAddressException;
import br.com.addressadmin.service.IAddressService;
import br.com.zipcodemodel.model.Address;
import br.com.zipcodemodel.model.Zipcode;

@RestController
public class AddressController {
	
	@Autowired
	private IAddressService zipCodeService;
	
	@RequestMapping(value = "/address/{idAddress}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Zipcode> deleteAddressById(@PathVariable("idAddress") final int idAddress) 	throws Exception { 
		
	    zipCodeService.delete(idAddress);
	   
		return new ResponseEntity<Zipcode>(HttpStatus.OK);

	}

	@RequestMapping(value = "/address/{idAddress}", method = RequestMethod.POST, 
										  consumes = MediaType.APPLICATION_JSON_VALUE,
										  produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AddressResponse> updateAddress(@PathVariable("idAddress") final int idAddress, 
									      @Valid  @RequestBody final Address address) throws Exception {
 
		zipCodeService.update(idAddress,address);		

 
		AddressResponse response = new AddressResponse(HttpStatus.OK,"",address);

		
		return new ResponseEntity<AddressResponse>(response,HttpStatus.OK);

	}
	
	@ExceptionHandler(HttpClientErrorException.class)
	public ResponseEntity<AddressResponse> handleException(HttpClientErrorException e) {
	 
		AddressResponse response = new AddressResponse(HttpStatus.BAD_REQUEST, e.getResponseBodyAsString(), null);

		return new ResponseEntity<AddressResponse>(response,HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(NotFoundAddressException.class)
	public ResponseEntity<AddressResponse> handleException(NotFoundAddressException e) {
	 
		AddressResponse response = new AddressResponse(HttpStatus.BAD_REQUEST, e.getMessage(), null);

		return new ResponseEntity<AddressResponse>(response,HttpStatus.BAD_REQUEST);
	}
}
