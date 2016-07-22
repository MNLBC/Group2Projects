
package com.oocl.mnlbc.model;

import java.util.List;

import org.springframework.validation.ObjectError;

/**
 * @author Kassandra Ysabel Fuentes
 * @since 07-21-2016
 */
public class Response {
	private int responseCode;
	private List<ObjectError> errors;
	/**
	 * @return the responseCode
	 */
	public int getResponseCode() {
		return responseCode;
	}
	/**
	 * @param responseCode the responseCode to set
	 */
	public void setResponseCode(int responseCode) {
		switch(responseCode)
	      {
	         case 0 :
	            System.out.println("Successfully saved in database"); 
	            break;
	         case 1 :
	        	 System.out.println("Database error"); 
		            break;
	         case 2 :
	        	 System.out.println("User is null"); 
		            break;
	         default :
	            System.out.println("Binding error");
	      }
	}
	/**
	 * @return the errors
	 */
	public List<ObjectError> getErrors() {
		return errors;
	}
	/**
	 * @param list the errors to set
	 */
	public void setErrors(List<ObjectError> list) {
		this.errors = list;
	}
	
	
}
