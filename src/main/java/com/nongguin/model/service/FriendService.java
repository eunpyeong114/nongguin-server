package com.nongguin.model.service;

import java.util.List;

import com.nongguin.model.dto.Friend;

public interface FriendService {
	// 유저(사용자) 기준 내가 친구 요청한 친구 목록 찾기
	List<Friend> getFriendsByFrom(int userId);
	// 서로 친구인지 체크
	Friend checkIsFriend(Friend friend);
	// 친구 요청
	boolean insertReq(Friend friend);
	// 유저가 받은 친구 요청 조회하기
	List<Friend> getRequestsByUserId(int userId);
	// 친구 요청 수락하기
	boolean acceptRequest(Friend friend);
	// 친구 요청 거절하기
	boolean refuseRequest(Friend friend);
	
}
