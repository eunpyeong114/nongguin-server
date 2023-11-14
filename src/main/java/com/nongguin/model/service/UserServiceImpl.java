package com.nongguin.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

import com.nongguin.model.dao.UserDao;
import com.nongguin.model.dto.User;

@Configuration
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	@Override
	public Boolean signUp(User user) {
		int result = userDao.signUp(user);
		System.out.println(3/0);
		if (result > 0)
			return true;
		return false;
	}

	@Override
	public User signIn(User user) {
		return userDao.signIn(user);
	}

	@Override
	public boolean deleteUser(String userId) {
		int result = userDao.deleteUser(userId);
		if (result > 0)
			return true;
		return false;
	}

	@Override
	public User getUserByUserId(String userId) {
		return userDao.getUserByUserId(userId);
	}

	@Override
	public boolean modifyUser(User user) {
		int result = userDao.modifyUser(user);
		if (result > 0)
			return true;
		return false;
	}

}
