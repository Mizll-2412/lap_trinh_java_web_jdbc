package com.laptrinhjavaweb.service.impl;

import javax.inject.Inject;

import com.laptrinhjavaweb.dao.IUserDAO;
import com.laptrinhjavaweb.dao.impl.UserDAO;
import com.laptrinhjavaweb.model.UserModel;
import com.laptrinhjavaweb.service.IUserService;

public class UserService implements IUserService {
//	private IUserDAO userDao;
//	public UserService(){
//		userDao=new UserDAO();
//	}

	@Inject
	private IUserDAO userDao;
	@Override
	public UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status) {
		return userDao.findByUserNameAndPasswordAndStatus(userName, password, status);
	}

}
