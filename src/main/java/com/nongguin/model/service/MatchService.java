package com.nongguin.model.service;

import java.util.Date;
import java.util.List;

import com.nongguin.model.dto.Match;
import com.nongguin.model.dto.SearchCondition;

public interface MatchService {

	List<Match> getMatchsByDay(Date matchDate);

	List<Match> getMatchsBySearchCondition(SearchCondition condition);

	Match getMatchByMatchId(int matchId);

	List<Match> getMatchsByUserId(int userId);

	List<Match> getRemainingMatchsByUserId(int userId);

	int getCourtCapacity(int matchId);

	int getMatchApplicantCnt(int matchId);

}
