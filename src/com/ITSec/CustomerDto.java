package com.ITSec;

import java.util.List;

public class CustomerDto {
	
	private String message;
	
	private List<Object> customerList;

	public String getMessage() {
		return message;
	}

	public List<Object> getCustomerList() {
		return customerList;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setCustomerList(List<Object> customerList) {
		this.customerList = customerList;
	}
	
	
	

}
