package com.itheima.service.impl;

import com.itheima.dao.IUserDAO;
import com.itheima.dao.impl.UserDAOImpl;
import com.itheima.domain.User;
import com.itheima.service.IUserService;
import com.itheima.utils.BeanFactory;

public class UserServiceImpl implements IUserService {

	//登录操作
	@Override
	public User login(String username, String password) {
//		IUserDAO userDao= new UserDAOImpl();
		
		String path=this.getClass().getClassLoader().getResource("/bean.xml").getFile();
		
		IUserDAO userDao= (IUserDAO) BeanFactory.createBean("userDao", path);
		
		
		try {
		  return userDao.findUserByUsernameAndPassword(username,password);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}

}
