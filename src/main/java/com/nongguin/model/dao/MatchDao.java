package com.nongguin.model.dao;

import java.util.List;

import com.nongguin.model.dto.Match;
import com.nongguin.model.dto.SearchCondition;
import com.nongguin.model.dto.SearchResult;

public interface MatchDao {

	List<Match> getMatchsByDay(String matchDate);

	List<Match> getMatchsBySearchCondition(SearchCondition condition);

	SearchResult getMatchByMatchId(int matchId);

	List<Match> getMatchsByUserId(int userId);

	SearchResult getRemainingMatchsByUserId(int userId);

	int getCourtCapacity(int matchId);

	int getMatchApplicantCnt(int matchId);

	int plusApplicantCnt(int matchId);

}
