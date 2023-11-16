package com.nongguin.model.service;

import java.util.List;

import com.nongguin.model.dto.Match;
import com.nongguin.model.dto.SearchCondition;
import com.nongguin.model.dto.SearchResult;

public interface MatchService {

	List<Match> getMatchsByDay(String matchDate);

	List<Match> getMatchsBySearchCondition(SearchCondition condition);

	SearchResult getMatchByMatchId(int matchId);

	List<SearchResult> getMatchsByUserId(List matchIds);

	List<SearchResult> getRemainingMatchsByUserId(List matchIds);

	int getCourtCapacity(int matchId);

	int getMatchApplicantCnt(int matchId);

}
