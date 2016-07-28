package com.oocl.mnlbc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.oocl.mnlbc.util.Config;
import com.oocl.mnlbc.util.LogType;
import com.oocl.mnlbc.util.LogUtil;

/**
 * Controller for retrieving and comparing premium code for registration
 * @author KALINWI2
 * @since 22-JUL-2016
 */

@RestController
public class PremiumRegisterController {

	@RequestMapping(value = "/premiumRegister", method = RequestMethod.POST)
	public String validatePremiumCode(@RequestParam("premiumCode") String premiumCode){
		LogUtil.logMsg(LogType.INFO, "Validating Premium Code: " + premiumCode);
		String validPremiumCode = Config.getConfigValue("premiumCode");
		if(validPremiumCode.equals(premiumCode)){
			LogUtil.logMsg(LogType.INFO, "Valid Premium Code");
			return "success";
		}
		else{
			LogUtil.logMsg(LogType.WARN, "Code not Valid");
			return "failed";
		}
	}
}
