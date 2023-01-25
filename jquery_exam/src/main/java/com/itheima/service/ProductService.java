package com.itheima.service;

import java.sql.SQLException;
import java.util.List;

import com.itheima.dao.ProductDAO;
import com.itheima.domain.Product;

public class ProductService {
	
	public List<Product> findAll(int pageNo,int pageSize) throws SQLException {
		ProductDAO dao = new ProductDAO();
		return dao.findAll(pageNo,pageSize);
	}

}
