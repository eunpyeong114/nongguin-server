package com.nongguin.model.dao;

import com.nongguin.model.dto.User;

public interface UserDao {

	int signUp(User user);

	User signIn(User user);

	int deleteUser(int userId);

	User getUserByUserId(int userId);

	int modifyUser(User user);

	User getUserByEmail(String userEmail);

}
