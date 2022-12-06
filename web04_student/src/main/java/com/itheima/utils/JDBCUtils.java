package com.itheima.utils;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 *JDBC工具类 使用Durid连接池
 * @author jack
 *
 */
public class JDBCUtils {
 static  ComboPooledDataSource dataSource = new ComboPooledDataSource();
	
	/**
	 * 获得连接的方法
	 * @throws SQLException 
	 */
	public static Connection getConnection() throws SQLException {
		
		return dataSource.getConnection();
	}
	/**
	 * 获得连接池
	 */
	public static DataSource getDataSource() {
		return dataSource;
		
	}
	
	/**
	 * 释放资源的方法
	 */
	public static void  release(Statement stmt,Connection conn) {
		//资源释放
		if(stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			stmt = null;
		}
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			conn = null;
		
		}
	}
    public static void  release(ResultSet rs,Statement stmt,Connection conn) {
    	//资源释放
		if(stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			stmt = null;
		}
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			conn = null;
		}
		if( rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			rs = null;
		}
	}
}
