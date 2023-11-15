package com.nongguin.model.service;

import com.nongguin.model.dto.User;

public interface UserService {
	Boolean signUp(User user);

	User signIn(User user);

	boolean deleteUser(int userId);

	User getUserByUserId(int userId);

	boolean modifyUser(User user);
	
	User getUserByEmail(String userEmail);
}
