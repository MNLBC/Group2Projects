
package com.oocl.mnlbc.model;

import java.util.List;

import org.springframework.validation.ObjectError;

import com.oocl.mnlbc.util.LogType;
import com.oocl.mnlbc.util.LogUtil;

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
	            LogUtil.logMsg(LogType.INFO, "Successfully saved in database");
	            break;
	         case 1 :
	        	 LogUtil.logMsg(LogType.WARN, "Error in database");
		            break;
	         case 2 :
	        	 LogUtil.logMsg(LogType.WARN, "User is null"); 
		            break;
	         case 3 :
	        	 LogUtil.logMsg(LogType.WARN, "Login Failed"); 
		            break;
	         case 4 :
	        	 LogUtil.logMsg(LogType.INFO, "Login Successful"); 
		            break;
	         default :
	        	 LogUtil.logMsg(LogType.WARN, "Binding error");
	      }
		this.responseCode = responseCode;
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
