package com.nongguin.model.service;

import java.util.List;

import com.nongguin.model.dto.Friend;

public interface FriendService {
	// 유저(사용자) 기준 내가 친구 요청한 친구 목록 찾기
	List<Friend> getFriendsByFrom(int userId);
	// 서로 친구인지 체크
	boolean checkIsFriend(int friendId, int userId);
	
}
