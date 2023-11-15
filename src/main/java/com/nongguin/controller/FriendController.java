package com.nongguin.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nongguin.model.dto.Friend;
import com.nongguin.model.dto.User;
import com.nongguin.model.service.FriendService;
import com.nongguin.model.service.UserService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/friend")
@Api(tags = "친구 컨트롤러")
public class FriendController {

	@Autowired
	FriendService friendService;

	@Autowired
	UserService userService;
	
	@GetMapping("/list")
	public ResponseEntity<?> getAllFriends(int userId){
		// 내가 신청한 친구 목록들 조회
		List<Friend> MyReqlist = friendService.getFriendsByFrom(userId);
		// 내가 신청한 친구들 중 수락한 친구들(유저아이디) 조회
		List<Integer> FriendRel = new ArrayList<>();
		for(int i = 0; i<MyReqlist.size() ; i++) {
			int friendId = MyReqlist.get(i).getFriendToUser();
			// 서로 친구인지 확인 
			boolean result = friendService.checkIsFriend(friendId,userId);
			// 친구라면 리스트에 추가하기
			if(result) 
				FriendRel.add(friendId);
		}
		List<User>result = new ArrayList<User>();
		for(int i = 0; i<FriendRel.size(); i++) {
			result.add(userService.getUserByUserId(FriendRel.get(i)));
		}
		if(result==null || result.size()==0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<User>>(result,HttpStatus.OK);
	}	
}
