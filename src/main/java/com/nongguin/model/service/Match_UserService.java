package com.nongguin.model.service;

import java.util.List;

public interface Match_UserService {

	int insertData(int userId, int matchId);
	// 매치 아이디 반환
	List<Integer> getMatchIdByUserId(int userId);
}
