package com.itheima.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.itheima.dao.ICustomerDAO;
import com.itheima.domain.Customer;
import com.itheima.utils.JdbcUtils;

public class CustomerDAOImpl implements ICustomerDAO {
    
	//添加客户
	//@Override
	public void addCustomer(Customer c) throws SQLException {
		QueryRunner runner= new QueryRunner();
		runner.update(JdbcUtils.getConnection(),"insert into customer values(null,?,?,0,?)",
				c.getC_name(),c.getEmail(),c.getPassword());
		
	}
    //根据客户名称查询客户
	@Override
	public Customer findByName(String c_name) throws Exception {
		QueryRunner runner= new QueryRunner();
		return runner.query(JdbcUtils.getConnection(),
				"select * from customer where c_name=?",new BeanHandler<Customer>(Customer.class),c_name);
	}
	//根据邮箱查找
	@Override
	public Customer findByEmail(String email) throws Exception {
		QueryRunner runner= new QueryRunner(JdbcUtils.getDataSource());
		return runner.query("select * from customer where email=?",new BeanHandler<Customer>(Customer.class),email);
	}
	
	//修改邮箱状态
	@Override
	public void updateEmailStatus(String email) throws Exception {
		QueryRunner runner= new QueryRunner(JdbcUtils.getDataSource());
		 runner.update("uodate customer set email_status=1 where email=?",email);
	
	}
	

}
