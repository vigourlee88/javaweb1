package com.itheima.dao;

import java.sql.SQLException;

import com.itheima.domain.Account;

public interface IAccountDAO {

	void addAccount(Account account) throws SQLException;
	

}
