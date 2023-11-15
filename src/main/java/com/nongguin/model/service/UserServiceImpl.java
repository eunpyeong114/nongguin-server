package com.nongguin.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nongguin.model.dao.UserDao;
import com.nongguin.model.dto.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	@Override
	public Boolean signUp(User user) {
		int result = userDao.signUp(user);
		if (result > 0)
			return true;
		return false;
	}

	@Override
	public User signIn(User user) {
		return userDao.signIn(user);
	}

	@Override
	public boolean deleteUser(int userId) {
		int result = userDao.deleteUser(userId);
		if (result > 0)
			return true;
		return false;
	}

	@Override
	public User getUserByUserId(int userId) {
		return userDao.getUserByUserId(userId);
	}

	@Override
	public boolean modifyUser(User user) {
		int result = userDao.modifyUser(user);
		if (result > 0)
			return true;
		return false;
	}

	@Override
	public User getUserByEmail(String userEmail) {
		User user = userDao.getUserByEmail(userEmail);
		return user;
	}

}
