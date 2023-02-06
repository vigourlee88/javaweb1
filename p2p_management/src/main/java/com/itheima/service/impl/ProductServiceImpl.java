package com.itheima.service.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.itheima.dao.IProductDAO;
import com.itheima.dao.impl.ProductDAOImpl;
import com.itheima.domain.Product;
import com.itheima.service.IProductService;
import com.itheima.utils.RedisUtils;

public class ProductServiceImpl implements IProductService {
  //查询所有
	@Override
	public List<Product> findAll() {
		IProductDAO productDao =new ProductDAOImpl();
		try{
			return productDao.findAll();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
  //添加
//	@Override
	public void add(Product p) {
		IProductDAO productDao =new ProductDAOImpl();
		productDao.add(p);
	}
	
   //查询所有产品方法
	public void findAll(HttpServletRequest request,HttpServletResponse response) throws IOException {
		//先从redis中获取
		String jsonValue = RedisUtils.get("products");
		
		if(jsonValue==null) {
			
		//调用service获取所有产品信息
		IProductService productService= new ProductServiceImpl();
		List<Product> ps= productService.findAll();
		
		//将ps转换成json响应到浏览器
		jsonValue=JSONObject.toJSONString(ps);
		//调用service从服务器查询的jason串
		RedisUtils.set("products", jsonValue);
		
		//重新存储到redis中(key,value)
		RedisUtils.set("products",jsonValue);
		
		}
		//判断是否是跨域访问
		String callback=request.getParameter("callback");
		
		if(callback == null || "".equals(callback)) {
			response.getWriter().write(jsonValue);
			return;
		}else {
			response.getWriter().write(callback+"("+jsonValue+")");
			return;
			
		}
	}
  //根据id查询
	@Override
	public Product findById(int id)  {
		IProductDAO productDao =new ProductDAOImpl();
		try {
			return productDao.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	//根据id修改产品
	@Override
	public void update(Product p) {
		IProductDAO productDao =new ProductDAOImpl();
		try {
			productDao.update(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
}
