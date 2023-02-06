package com.itheima.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.itheima.dao.IAccountDAO;
import com.itheima.domain.Account;
import com.itheima.utils.JdbcUtils;

public class AccountDAOImpl implements IAccountDAO {
     
	
	
	@Override
	public void addAccount(Account account) throws SQLException {
		QueryRunner runner = new QueryRunner();
		runner.update(JdbcUtils.getConnection(),"insert into account values(null,?,?,?,?)",account.getTotal(),account.getBalance(),account.getInterest(),account.getC().getId());


	}
	
}
