package com.nongguin.model.dao;

import com.nongguin.model.dto.User;

public interface UserDao {

	int signUp(User user);

	User signIn(User user);

	int deleteUser(String userId);

	User getUserByUserId(String userId);

	int modifyUser(User user);

}
