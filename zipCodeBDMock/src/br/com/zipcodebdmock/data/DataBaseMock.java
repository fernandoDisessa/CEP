package br.com.zipcodebdmock.data;

import java.util.ArrayList;
import java.util.List;

import br.com.zipcodemodel.model.Address;
import br.com.zipcodemodel.model.Zipcode;

public class DataBaseMock {

	public static List<Zipcode> zipcodes;
	public static List<Address> addresses;

	static {

		zipcodes = new ArrayList<Zipcode>();
		addresses = new ArrayList<Address>();

		Zipcode zip = new Zipcode();
		zip.setId(1);
		zip.setZipcode("12345678");

		Address address = new Address();
		address.setZipcode(zip);
		address.setId(1);
		address.setStreet("street");

		addresses.add(address);
 

		zipcodes.add(zip);

	}

	public static Zipcode find(String zipcode) {

		for (Zipcode zip : zipcodes) {

			if (zip.getZipcode().equals(zipcode)) {
				return zip;
			}

		}

		return null;
	}

	public static boolean delete(int idAddress) {

		boolean found = false;
		 

			for (Address a :addresses) {

				if (a.getId() == idAddress) {
					found=true;
					addresses.remove(a);
					break;
				}

			}
		  
		return found;
	}
	
	public static boolean updateAddress(int idAddress, Address address){
	 
		boolean found = false;
		 

			for (Address a : addresses ) {

				if (a.getId() == idAddress) {
					found=true;
					address.setId(a.getId());
					addresses.remove(a);
					addresses.add(address);
					break;
				} 
			}
	  
		return found;
		 
	}
}
