package com.nongguin.model.dao;

import java.util.List;

import com.nongguin.model.dto.Friend;

public interface FriendDao {

	List<Friend> getFriendsByFrom(int userId);

	Friend checkIsFriend(int friendId, int userId);

}
