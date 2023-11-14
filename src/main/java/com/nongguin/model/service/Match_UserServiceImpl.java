package com.nongguin.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.nongguin.model.dao.Match_UserDao;

@Configuration
public class Match_UserServiceImpl implements Match_UserService {

	@Autowired
	Match_UserDao muDao;
	
	@Override
	public int insertData(int userId, int matchId) {
		return muDao.insertData(userId, matchId);
	}

}
