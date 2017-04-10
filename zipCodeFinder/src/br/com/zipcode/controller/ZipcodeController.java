package br.com.zipcode.controller;

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

import br.com.zipcode.exception.InvalidZipCodeException;
import br.com.zipcode.exception.NotFoundCepException;
import br.com.zipcode.service.IZipCodeService;
import br.com.zipcodemodel.model.Zipcode;

/**Class to expose a REST service and find an address by a zipcode 
 * @author Fernando Disessa Pereira  
 */ 
@RestController
@RequestMapping("v1/cep")
public class ZipcodeController {
  
	@Autowired
	private IZipCodeService zipcodeService;
 
	 /** Find an address by zipcode 
     * @param  zipcode
     * @return ResponseEntity<Zipcode>
     */
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Zipcode> findByCep(@RequestBody  final Zipcode zipcode) throws Exception { 

		Zipcode zipcodeFound = zipcodeService.findByZipcode(zipcode.getZipcode());

		return new ResponseEntity<Zipcode>(zipcodeFound, HttpStatus.OK);

	} 

	@ExceptionHandler(InvalidZipCodeException.class)
	public ResponseEntity<ZipCodeResponse> handleException(InvalidZipCodeException e) {

		ZipCodeResponse response = new ZipCodeResponse(HttpStatus.BAD_REQUEST,"", e.getMessage(), null);

		return new ResponseEntity<ZipCodeResponse>(response,HttpStatus.BAD_REQUEST);
	}
	

	@ExceptionHandler(NotFoundCepException.class)
	public ResponseEntity<ZipCodeResponse> handleException(NotFoundCepException e) {

		ZipCodeResponse response = new ZipCodeResponse(HttpStatus.BAD_REQUEST,"", e.getMessage(), null);

		return new ResponseEntity<ZipCodeResponse>(response,HttpStatus.BAD_REQUEST);
	}

}
