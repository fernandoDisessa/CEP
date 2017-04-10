package br.com.zipcode.util;

import br.com.zipcode.exception.IllegalArgumentException;

public class GenericValidateUtil {

	private static final String NULL_PARAM_ERROR = "Param cannot be null";

	private static final String EMPTY_PARAM_ERROR = "Param cannot be empty";
	
	private static final String NULL_EMPTY_PARAM_ERROR = "Param cannot be empty or null";	 
	
	public static void notNullObj(final Object obj) throws IllegalArgumentException {

		if (isNullObj(obj)) {
			throw new IllegalArgumentException(NULL_PARAM_ERROR);
		}
	}
	
	public static void notEmptyStr(final String str) throws IllegalArgumentException {

		if (isEmptyStr(str)) {
			throw new IllegalArgumentException(EMPTY_PARAM_ERROR);
		}
	}
	
	public static void notEmptyAndNotNullStr(final String str) throws IllegalArgumentException {

		if (isEmptyStr(str) || isNullObj(str)) {
			throw new IllegalArgumentException(NULL_EMPTY_PARAM_ERROR);
		}
	}
	
	private static boolean isNullObj(Object obj){
		if (obj == null) {
		return true;
		}
		
		return false;
	}
	

	private static boolean isEmptyStr(String str){
		if (str.trim().equals("")) {
		return true;
		}
		
		return false;
	}
 

}
