package com.nongguin.model.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nongguin.model.dao.MatchDao;
import com.nongguin.model.dto.Match;
import com.nongguin.model.dto.SearchCondition;

@Service
public class MatchServiceImpl implements MatchService {
	@Autowired
	MatchDao matchDao;
	
	@Override
	public List<Match> getMatchsByDay(Date matchDate) {
		return matchDao.getMatchsByDay(matchDate);
	}

	@Override
	public List<Match> getMatchsBySearchCondition(SearchCondition condition) {
		return matchDao.getMatchsBySearchCondition(condition);
	}

	@Override
	public Match getMatchByMatchId(int matchId) {
		return matchDao.getMatchByMatchId(matchId);
	}

	@Override
	public List<Match> getMatchsByUserId(int userId) {
		return matchDao.getMatchsByUserId(userId);
	}

	@Override
	public List<Match> getRemainingMatchsByUserId(int userId) {
		return matchDao.getRemainingMatchsByUserId(userId);
	}

	@Override
	public int getCourtCapacity(int matchId) {
		return matchDao.getCourtCapacity(matchId);
	}

	@Override
	public int getMatchApplicantCnt(int matchId) {
		return matchDao.getMatchApplicantCnt(matchId);
	}

}
