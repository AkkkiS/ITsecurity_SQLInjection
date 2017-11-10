package com.ITSec;


class Customers{
	
	private Long customer_id;
	private String customer_firstname;
	private String city;
	private String country;
	private String customer_lastname;
	private String state;
	private String county;
	
	
	public Long getCustomer_id() {
		return customer_id;
	}
	public String getCustomer_firstname() {
		return customer_firstname;
	}
	public String getCity() {
		return city;
	}
	public String getCountry() {
		return country;
	}
	public String getCustomer_lastname() {
		return customer_lastname;
	}
	public String getState() {
		return state;
	}
	public String getCounty() {
		return county;
	}
	public void setCustomer_id(Long customer_id) {
		this.customer_id = customer_id;
	}
	public void setCustomer_firstname(String customer_firstname) {
		this.customer_firstname = customer_firstname;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public void setCustomer_lastname(String customer_lastname) {
		this.customer_lastname = customer_lastname;
	}
	public void setState(String state) {
		this.state = state;
	}
	public void setCounty(String county) {
		this.county = county;
	}	
	
}
