package com.itheima.dao;



import com.itheima.domain.Customer;

public interface ICustomerDAO {

	void addCustomer(Customer c) throws Exception;

	Customer findByName(String c_name) throws Exception;
	
	Customer findByEmail(String email) throws Exception;

	void updateEmailStatus(String email) throws Exception;
	
	


	
	

}
