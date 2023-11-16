package com.nongguin.model.dao;

import java.util.List;

public interface Match_UserDao {

	int insertData(int userId, int matchId);

	List<Integer> getMatchIdByUserId(int userId);

}
