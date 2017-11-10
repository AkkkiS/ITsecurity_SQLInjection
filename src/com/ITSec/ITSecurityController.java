package com.ITSec;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nl.captcha.Captcha;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/ITSec")
public class ITSecurityController{

	@RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
	public String getLoginPage() throws Exception {
		return "LoginWithoutValidation";
	}
	
	
	
	@RequestMapping( value = "/getDataTableWithoutValidation")
	public String getDataTableWithoutValidation( HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		return "dataTableWithoutValidation";
	}

	

	@RequestMapping( value = "/searchForDataTableWithoutValidation", method = {RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody List<Object> searchCustomerForDataTable(HttpServletRequest request, 
			HttpServletResponse response, @RequestBody CustomerSearch customer) throws Exception {

		ITSecurityServiceImpl service = new ITSecurityServiceImpl();

		List<Object> customerList = null;    

		customerList = service.searchForDataTableWithValidation(customer.getSearchString(), customer.getSearchType());     

		return customerList;
	}

	
	@RequestMapping( value = "/insertUser", method = {RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody String insertUser(HttpServletRequest request, 
			HttpServletResponse response, @RequestBody Users user) throws Exception {

		ITSecurityServiceImpl service = new ITSecurityServiceImpl();

		String message = service.insertHashedPwd(user.getUserName() , user.getUserPassword());

		return message;
	}

	
	@RequestMapping( value = "/checkUser", method = {RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody int validateUser(HttpServletRequest request, 
			HttpServletResponse response, @RequestBody Users user) throws Exception {

		ITSecurityServiceImpl service = new ITSecurityServiceImpl();

		

		String userName = user.getUserName();


		String password = user.getUserPassword();

		int result = service.checkUser(userName , password);

		return result;
	}

}
