package com.itheima.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.itheima.domain.Product;
import com.itheima.utils.JdbcUtils;


public class ProductDAO {
	
	//pageNo页码
	//pageSize每页条数
	public List<Product> findAll(int pageNo,int pageSize) throws SQLException{
		
		QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());//连接池默认查找c3p0
	    
		return runner.query("select * from product limit ?,?",new BeanListHandler<Product>(Product.class),
				(pageNo - 1)*pageSize,pageSize);
	
	}

}
