package com.nongguin.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	public boolean checkIsFriend(Friend friend) {
		Friend dbfriend = friendDao.checkIsFriend(friend);
		if (dbfriend == null)
			return false;
		return true;
	}

	@Transactional
	@Override
	// 친구 요청
	public boolean insertReq(Friend friend) {
		try {
			int fromResult = friendDao.insertReqByFrom(friend);
			if (fromResult <= 0)
				return false;
		} catch (Throwable e) {
			System.out.println(e);
		}
		try {
			int toResult = friendDao.insertReqByTo(friend);
			if (toResult <= 0)
				return false;
		} catch (Throwable e) {
			System.out.println(e);
		}
		return true;
	}

	@Override
	public List<Friend> getRequestsByUserId(int userId) {
		return friendDao.getRequestsByUserId(userId);
	}

	@Override
	public boolean acceptRequest(Friend friend) {
		int result = friendDao.acceptRequest(friend);
		if (result > 0)
			return true;
		return false;
	}

	@Transactional
	@Override
	public boolean refuseRequest(Friend friend) {
		int result = friendDao.deleteRequest(friend);
		if (result > 1)
			return true;
		return false;
	}

}
