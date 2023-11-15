package com.nongguin.model.dao;

import java.util.List;

import com.nongguin.model.dto.Friend;

public interface FriendDao {

	List<Friend> getFriendsByFrom(int userId);

	Friend checkIsFriend(Friend friend);

	int insertReqByFrom(Friend friend);

	int insertReqByTo(Friend friend);

	List<Friend> getRequestsByUserId(int userId);

	int acceptRequest(Friend friend);

	int deleteRequest(Friend friend);
}
