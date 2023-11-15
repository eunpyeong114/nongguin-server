package com.nongguin.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nongguin.model.dao.FriendDao;
import com.nongguin.model.dto.Friend;

@Service
public class FriendServiceImpl implements FriendService {

	@Autowired
	FriendDao friendDao;
	
	@Override
	// 유저(사용자) 기준 내가 친구 요청한 친구 목록 찾기
	public List<Friend> getFriendsByFrom(int userId) {
		return friendDao.getFriendsByFrom(userId);
	}

	@Override
	// 서로 친구인지 체크
	public boolean checkIsFriend(int friendId, int userId) {
		Friend friend= friendDao.checkIsFriend(friendId,userId);
		if(friend == null)
			return false;
		return true;
	}

}
