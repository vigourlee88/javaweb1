package com.itheima.service;

import com.itheima.domain.Customer;

public interface ICustomerService {

	void addCustomer(Customer c);

	Customer findByName(String c_name) throws Exception;

	Customer findByEmail(String c_name) throws Exception;

	void updateEmailStatus(String email) throws Exception;


	
	
	
	

}
