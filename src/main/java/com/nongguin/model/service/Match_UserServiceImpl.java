package com.nongguin.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nongguin.model.dao.Match_UserDao;

@Service
public class Match_UserServiceImpl implements Match_UserService {

	@Autowired
	Match_UserDao muDao;
	
	@Override
	public int insertData(int userId, int matchId) {
		return muDao.insertData(userId, matchId);
	}

	@Override
	public List<Integer> getMatchIdByUserId(int userId) {
		return muDao.getMatchIdByUserId(userId);
	}

}
