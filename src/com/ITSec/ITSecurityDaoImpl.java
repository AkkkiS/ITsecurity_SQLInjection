package com.ITSec;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

class ITSecurityDaoImpl{


	public void insertNewUser(Long userId, String userName, String password) throws Exception {

		ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");

		JdbcTemplate jdbcTemplate = (JdbcTemplate) appContext.getBean("jdbcTemplate");

		jdbcTemplate.execute("INSERT INTO USERS VALUES(" + userId + ",'" + userName + "','" + password + "')");

		//List<Users> userlist = jdbcTemplate.query("SELECT * FROM USERS", new UserMapper());

		//System.out.println(userlist.size());


	}
	
	
	public Users checkUserPassword(String userName, String userPassword) {
		
		ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");

		JdbcTemplate jdbcTemplate = (JdbcTemplate) appContext.getBean("jdbcTemplate");
		
		Users user = null;
		
		String query = "SELECT * FROM USERS WHERE USERNAME = '" + userName + "' AND USERPASSWORD = '" + userPassword + "'";
		
		System.out.println(" asdhakjfdad  " + query);
		try {
			user = jdbcTemplate.queryForObject(query, new UserMapper());	
		}catch( Exception ex ) {
			System.out.println("No Entry found");
		}
		
		return user;
	}


	public Long getMaxOfUserId(){

		ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");

		JdbcTemplate jdbcTemplate = (JdbcTemplate) appContext.getBean("jdbcTemplate");

		Long userId = jdbcTemplate.queryForLong("SELECT MAX(USERID) FROM USERS");

		return userId;
	}


	public boolean checkUserExists(String userName) {

		ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");

		JdbcTemplate jdbcTemplate = (JdbcTemplate) appContext.getBean("jdbcTemplate");

		int userCount = jdbcTemplate.queryForInt("SELECT COUNT(*) FROM USERS WHERE USERNAME = '" + userName + "'");

		return userCount > 0 ? true : false;
	}


	public List<Customers> getCustomerBasedOnType(String searchString, String searchType) {

		ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");

		JdbcTemplate jdbcTemplate = (JdbcTemplate) appContext.getBean("jdbcTemplate");

		List<Customers> customerList = new ArrayList<Customers>();

		if( searchType.equals("1") ){

			customerList = jdbcTemplate.query("SELECT * FROM CUSTOMERS WHERE CUSTOMER_ID = '" + searchString + "'", new CustomersMapper());

		}else{

			customerList = jdbcTemplate.query("SELECT * FROM CUSTOMERS WHERE CUSTOMER_FIRSTNAME = '" + searchString + "'", new CustomersMapper());

		}

		return customerList;
	}


	
	
	public List<Object> getCustomerBasedOnTypeForDatatable(
			String searchString, String searchType) {

		ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");

		JdbcTemplate jdbcTemplate = (JdbcTemplate) appContext.getBean("jdbcTemplate");

		List<Customers> customerList = new ArrayList<Customers>();

		searchString = searchString.replace("*", "%");

		if( searchType.equals("1") ){

			customerList = jdbcTemplate.query("SELECT * FROM CUSTOMERS WHERE CUSTOMER_ID = '" + searchString + "'", new CustomersMapper());

		}else{

			customerList = jdbcTemplate.query("SELECT * FROM CUSTOMERS WHERE CUSTOMER_FIRSTNAME LIKE '" + searchString + "'", new CustomersMapper());

		}

		List<Object> finalResult = new ArrayList<Object>();

		List<String> arrayList = null;

		if( customerList != null ){

			for(Customers mapper : customerList){

				arrayList = new ArrayList<String>();

				arrayList.add(mapper.getCustomer_id().toString().trim());
				arrayList.add(mapper.getCustomer_firstname().trim());
				arrayList.add(mapper.getCustomer_lastname().trim());
				arrayList.add(mapper.getCity().trim());
				arrayList.add(mapper.getCounty().trim());
				arrayList.add(mapper.getState().trim());
				arrayList.add(mapper.getCountry().trim());	

				finalResult.add(arrayList);

			}
		}

		return finalResult;
	}


}

