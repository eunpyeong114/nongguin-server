package com.nongguin.model.service;

import com.nongguin.model.dto.User;

public interface UserService {
	Boolean signUp(User user);

	User signIn(User user);

	boolean deleteUser(String userId);

	User getUserByUserId(String userId);

	boolean modifyUser(User user);
}
