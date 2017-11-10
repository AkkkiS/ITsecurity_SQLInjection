package com.ITSec;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;



class CustomersMapper implements RowMapper<Customers>{

	@Override
	public Customers mapRow(ResultSet rs, int rowNum) throws SQLException {
			
		Customers customer = new Customers();
		customer.setCity(rs.getString("CITY"));		
		customer.setCustomer_id(rs.getLong("CUSTOMER_ID"));
		customer.setCustomer_firstname(rs.getString("CUSTOMER_FIRSTNAME"));
		customer.setCountry(rs.getString("COUNTRY"));
		customer.setCounty(rs.getString("COUNTY"));
		customer.setCustomer_lastname(rs.getString("CUSTOMER_LASTNAME"));
		customer.setState(rs.getString("CUST_STATE"));
		
		return customer;
	}
	
	
	
	
	
	
}