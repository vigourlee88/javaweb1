package com.itheima.dao.impl;

import com.itheima.domain.Customer;

public interface ICustomerDAO {
	
	void addCustomer(Customer c) throws Exception;
	
	Customer findByName(String c_name) throws Exception;
	
	Customer findByEmail(String email);

}
