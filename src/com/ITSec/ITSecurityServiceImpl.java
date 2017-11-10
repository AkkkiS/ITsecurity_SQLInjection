package com.ITSec;

import java.util.List;

public class ITSecurityServiceImpl {

	public String insertHashedPwd( String userName, String password ) throws Exception {
		
		System.out.print("BCrypt hashing started: ");
		
		ITSecurityDaoImpl daoImpl = new ITSecurityDaoImpl();
		
		boolean exists = daoImpl.checkUserExists(userName);
		
		if( exists ){
			
			return "This Username already exists.";
			
		}else{			
			
			daoImpl.insertNewUser( daoImpl.getMaxOfUserId() + 1 , userName, password);
			
		}
		
		return "User successfully added";
		
		

	}

	public int checkUser(String userName, String password) throws Exception {

		ITSecurityDaoImpl daoImpl = new ITSecurityDaoImpl();
		
		boolean exists = daoImpl.checkUserExists(userName);
		
		if( exists ){
			
			Users user = daoImpl.checkUserPassword(userName, password);

			if( user != null ){

				return 1;
				
			}else{

				return 0;
			}
			
		}else{
			
			return -1;
		}

		
	}
	
	

	public List<Customers> searchCustomer(String searchString, String searchType) {


		ITSecurityDaoImpl daoImpl = new ITSecurityDaoImpl();		
		
		return daoImpl.getCustomerBasedOnType(searchString, searchType);
	}

		public List<Object> searchForDataTableWithValidation(String searchString,
			String searchType) {


		ITSecurityDaoImpl daoImpl = new ITSecurityDaoImpl();		
		
		return daoImpl.getCustomerBasedOnTypeForDatatable(searchString, searchType);
	}

}
