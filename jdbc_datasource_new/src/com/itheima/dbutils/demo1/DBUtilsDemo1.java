package com.itheima.dbutils.demo1;



import java.sql.SQLException;

import org.junit.Test;

import com.iheima.jdbc.utils.JDBCUtils2;



/**
 * DBUtils的增删改操作
 * @author jack
 * @param <QueryRunner>
 *
 */
public class DBUtilsDemo1 {
	@Test
	/**
	 * 增加操作
	 */
	
	public void demo1() throws SQLException {
		//创建核心类QueryRunner
		QueryRunner queryRunner = new QueryRunner(JDBCUtils2.getDataSource());
		queryRunner.update("insert into account values (null,?,?)","ddd",10000);
	}

}
