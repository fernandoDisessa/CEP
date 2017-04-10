package br.com.addressadmin.rest;

 

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import br.com.zipcodemodel.model.Zipcode;

@Component
public class AddressRestHelper {

	private static String URL_REST_FIND_ZIPCODE="http://localhost:8080/v1/cep/";
	
	public ResponseEntity<Zipcode> find(String zipcode) {

		RestTemplate rest = new RestTemplate();
		
		String requestJson = "{\"zipcode\":\""+zipcode+"\"}";
		
		ResponseEntity<Zipcode> response = null;	 
		
		HttpHeaders headers = new HttpHeaders();
		
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<String> entity = new HttpEntity<String>(requestJson,headers);
		
		try {
			
			response = rest.postForEntity(URL_REST_FIND_ZIPCODE, entity, Zipcode.class);
 
		} catch (HttpClientErrorException e) {

			throw e;
		}

		return response;

	}

}
